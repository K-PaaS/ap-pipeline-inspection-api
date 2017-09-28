package paasta.delivery.pipeline.inspection.api.qualityProfile;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import paasta.delivery.pipeline.inspection.api.common.CommonService;
import paasta.delivery.pipeline.inspection.api.common.Constants;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dojun on 2017-06-19.
 */
@Service
public class QualityProfileService {

    private final CommonService commonService;

    /**
     * The Delivery server url.
     */
    @Value("${inspection.server.url}")
    public String inspectionServerUrl;

    // COMMON API
    @Value("${commonApi.url}")
    private String commonApiUrl;

    @Autowired
    QualityProfileService(CommonService commonService) {this.commonService = commonService;}



    /**
     * 품질 프로파일 조회 by id
     * @param id
     * @return
     */
    QualityProfile getQualityProfile(Long id) {
        QualityProfile qualityProfile = new QualityProfile();
        qualityProfile = (QualityProfile) commonService.sendRequestToCommon(qualityProfile, Constants.RESULT_STATUS_SUCCESS, "/qualityProfile/"+id, HttpMethod.GET);
        return qualityProfile;
    }





    /**
     * 품질 프로파일 삭제
     * @param id
     * @return
     */
//    String deleteQualityProfile(Long id) {
//        Map<String, String> resultModel = new LinkedHashMap<>();
//        QualityProfile qualityProfile = getQualityProfile(id);
//        resultModel = (Map)commonService.sendRequestToSonar(resultModel, "/api/qualityprofiles/delete?profileKey="+qualityProfile.getKey(), HttpMethod.POST);
//        resultModel = (Map)commonService.sendRequestToCommon(resultModel, resultModel.get("resultStatus"),"/qualityProfile/"+id, HttpMethod.DELETE);
//        return resultModel.get("resultStatus");
//    }


    /////////////////////////////////////////////////////////////////////////

    /**
     * 품질 프로파일 목록 조회
     * @return Map
     */
//    Map getQualityProfileList() {
//        Map<String, Object> resultModel = new HashMap<>();
//        resultModel = (Map)commonService.sendRequestToCommon(resultModel, Constants.RESULT_STATUS_SUCCESS, "/qualityProfile", HttpMethod.GET);
//        List<QualityProfile> qualityProfileList = (List)resultModel.remove("resultList");
//        resultModel.put("qualityProfiles", qualityProfileList);
//        return resultModel;
//    }
//    commonService.sendForm(inspectionServerUrl,"api/qualitygates/copy", HttpMethod.POST,  resultModel, QualityGate.class);


    List getQualityProfileList(String serviceInstancesId){
        System.out.println(" ::::::::::::::"+serviceInstancesId);
        return commonService.sendForm(commonApiUrl , "/qualityProfile/qualityProfileList?serviceInstancesId="+serviceInstancesId,HttpMethod.GET, null, List.class);
    }

    /**
     * qualityProfile 복제
     * @return
     */
    public QualityProfile qualityProfileCopy(QualityProfile qualityProfile){
        QualityProfile result = new QualityProfile();

        result = commonService.sendForm(inspectionServerUrl , "/api/qualityprofiles/copy",HttpMethod.POST, qualityProfile, QualityProfile.class);

        result.setServiceInstancesId(qualityProfile.getServiceInstancesId());
        result.setDefaultYn(qualityProfile.getDefaultYn());
        //sona에서 가져오 키값 셋팅해서 db로 저장
        result = commonService.sendForm(commonApiUrl , "/qualityProfile/qualityProfileCopy",HttpMethod.PUT, result, QualityProfile.class);

        return result;
    }

    /**
     * qualityProfile 삭제
     * @return
     */
    public QualityProfile deleteQualityProfile(QualityProfile qualityProfile){
        QualityProfile result = new QualityProfile();
        commonService.sendForm(inspectionServerUrl , "/api/qualityprofiles/delete",HttpMethod.POST, qualityProfile, QualityProfile.class);
        commonService.sendForm(commonApiUrl , "/qualityProfile/qualityProfileDelete",HttpMethod.POST, qualityProfile, String.class);
        commonService.sendForm(commonApiUrl,"/project/qualityProfileDelete",HttpMethod.PUT,qualityProfile,String.class);
        result.setResultStatus(Constants.RESULT_STATUS_SUCCESS);
        return result;
    }
    /**
     * qualityProfile 수정
     * @return
     */
    public QualityProfile updateQualityProfile(QualityProfile qualityProfile){
        QualityProfile result = new QualityProfile();
        commonService.sendForm(inspectionServerUrl , "/api/qualityprofiles/rename",HttpMethod.POST, qualityProfile, QualityProfile.class);
        result = commonService.sendForm(commonApiUrl , "/qualityProfile/qualityProfileUpdate",HttpMethod.POST, qualityProfile, QualityProfile.class);
        return result;
    }

    /**
     * qualityProfile 언어 리스트
     * @return
     */
    public QualityProfile qualityProfileLangList(){
        return commonService.sendForm(inspectionServerUrl , "/api/languages/list",HttpMethod.GET, null, QualityProfile.class);
    }

    /**
     * 품질 프로파일 생성
     * @param qualityProfile
     * @return qualityProfile
     */
    QualityProfile createQualityProfile(QualityProfile qualityProfile) {
/*
        qualityProfile = (QualityProfile) commonService.sendRequestToSonar(qualityProfile, "/api/qualityprofiles/create", HttpMethod.POST);
        qualityProfile = (QualityProfile) commonService.sendRequestToCommon(qualityProfile, qualityProfile.getResultStatus(), "/qualityProfile", HttpMethod.POST);
*/
        JsonNode result = commonService.sendForm(inspectionServerUrl, "/api/qualityprofiles/create", HttpMethod.POST, qualityProfile, JsonNode.class);
        qualityProfile.setName(result.get("profile").get("name").asText());
        qualityProfile.setKey(result.get("profile").get("key").asText());
        qualityProfile.setLanguage(result.get("profile").get("language").asText());
        qualityProfile.setLanguageName(result.get("profile").get("languageName").asText());
        qualityProfile = commonService.sendForm(commonApiUrl, "/qualityProfile/qualityProfilCreate",HttpMethod.PUT, qualityProfile, QualityProfile.class);


        return qualityProfile;
    }

    /**
     *  QualityProfile default setting
     *
     * @param
     * @return
     */
    public QualityProfile defaultQualityProfile(QualityProfile qualityProfile){

        commonService.sendForm(inspectionServerUrl , "/api/qualityprofiles/set_default",HttpMethod.POST, qualityProfile, QualityProfile.class);
        commonService.sendForm(commonApiUrl,"/qualityProfile/qualityProfilDefaultSetting",HttpMethod.PUT,qualityProfile,String.class);
        qualityProfile.setResultStatus(Constants.RESULT_STATUS_SUCCESS);
        return qualityProfile;
    }

    /**
     *  QualityProfile codingRules
     *
     * @param qualityProfile
     * @return list
     */
    public List getCodingRulesList(QualityProfile qualityProfile){
        return commonService.sendForm(inspectionServerUrl,"/api/profiles?language="+qualityProfile.getLanguage()+"&name="+qualityProfile.getName(),HttpMethod.GET,null,List.class);
    }
}