package delivery.pipeline.inspection.api.qualityGate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import delivery.pipeline.inspection.api.project.Project;

import java.io.IOException;
import java.util.List;

/**
 * apDeliveryPipelineApi
 * delivery.pipeline.inspection.api.qualityGate
 *
 * @author kimdojun
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/qualitygates")
public class QualityGateController {

    private final QualityGateService qualityGateService;

    @Autowired
    QualityGateController(QualityGateService qualityGateService) {
        this.qualityGateService = qualityGateService;
    }

    /**
     * Get qualityGates.
     *
     * @return the qualityGates
     */
//    @RequestMapping(method = RequestMethod.GET)
//    public Map getQualityGateList() {
//        // TODO :: MAY NOT BE USE
//        return qualityGateService.getQualityGateList();
//    }

    /**
     * Get specific qualityGate.
     *
     * @return the qualityGate
     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public QualityGate getQualityGate(@PathVariable Long id) {
//        return qualityGateService.getQualityGate(id);
//    }


    /**
     * Rename qualityGate.
     *
     * @return updated qualityGate
     */
//    @RequestMapping(value = "/rename/{id}", method = RequestMethod.PUT)
//    public QualityGate renameQualityGate(@PathVariable Long id, @RequestBody QualityGate qualityGate) {
//        return qualityGateService.renameQualityGate(id, qualityGate);
//    }


    ////////////////////////////////////////////////////////////////////

    /**
     * QualityGate 리스트 조회
     *
     * @param
     * @return QualityGate
     */
    @RequestMapping(value = "/qualityGateList", method = RequestMethod.GET)
    public List getQualityGateList(@RequestParam String serviceInstancesId) {
        List result = qualityGateService.getQualityGateList(serviceInstancesId);
        return result;
    }

    /**
     * QualityGate 조건 옵션조회
     *
     * @param
     * @return QualityGate
     */
    @RequestMapping(value = "/metricsList", method = RequestMethod.GET)
    public List getMetricsList() {
        return qualityGateService.getMetricsList();
    }

    /**
     * QualityGate 조건 목록
     *
     * @return
     */
    @RequestMapping(value = "/condition", method = RequestMethod.GET)
    public QualityGate getQualityGateCondition(@RequestParam long id) {
        return qualityGateService.getQualityGateCondition(id);
    }

    /**
     * QualityGate 조건 저장
     *
     * @return
     */
    @RequestMapping(value = "/qualityGateCondSave", method = RequestMethod.POST)
    public QualityGate createQualityGateCond(@RequestBody QualityGate qualityGate) {
        return qualityGateService.createQualityGateCond(qualityGate);

    }

    /**
     * QualityGate 조건 수정
     *
     * @return
     */
    @RequestMapping(value = "/qualityGateCondUpdate", method = RequestMethod.PUT)
    public QualityGate updateQualityGateCond(@RequestBody QualityGate qualityGate) {
        return qualityGateService.updateQualityGateCond(qualityGate);
    }

    /**
     * QualityGate 조건 삭제
     *
     * @return
     */
    @RequestMapping(value = "/qualityGateCondDelete", method = RequestMethod.DELETE)
    @ResponseBody
    public QualityGate deleteQualityGateCond(@RequestBody QualityGate qualityGate) {
        return qualityGateService.deleteQualityGateCond(qualityGate);
    }

    /**
     * QualityGate 복제
     *
     * @return
     */
    @RequestMapping(value = "/qualityGateCopy", method = RequestMethod.POST)
    @ResponseBody
    public QualityGate copyQualityGate(@RequestBody QualityGate qualityGate) {
        return qualityGateService.copyQualityGate(qualityGate);
    }


    /**
     * Create qualityGate.
     *
     * @return created qualityGate
     */
    @RequestMapping(value = "/qualityGateCreate", method = RequestMethod.POST)
    public QualityGate createQualityGate(@RequestBody QualityGate qualityGate) throws IOException {
        return qualityGateService.createQualityGate(qualityGate);
    }

    /**
     * Update qualityGate.
     *
     * @return updated qualityGate
     */
    @RequestMapping(value = "/qualityGateUpdate", method = RequestMethod.PUT)
    public QualityGate updateQualityGate(@RequestBody QualityGate qualityGate) {
        return qualityGateService.updateQualityGate(qualityGate);
    }

    /**
     * Delete qualityGate.
     *
     * @return created qualityGate
     */
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    public String deleteQualityGate(@PathVariable Long id) throws IOException {
//        return qualityGateService.deleteQualityGate(id);
//    }
    @RequestMapping(value = "/qualityGateDelete", method = RequestMethod.DELETE)
    public QualityGate deleteQualityGate(@RequestBody QualityGate qualityGate) throws IOException {
        return qualityGateService.deleteQualityGate(qualityGate);
    }

    /**
     * DefaultSetting qu.
     *
     * @return created qualityGate
     */
//    @RequestMapping(value = "/qualityGateDefaultSetting", method = RequestMethod.POST)
//    public QualityGate qualityGateDefaultSetting(@RequestBody QualityGate qualityGate){
//        return qualityGateService.qualityGateDefaultSetting(qualityGate);
//    }


    /**
     * getProjectList
     *
     * @param
     * @return List
     */
    @RequestMapping(value = "/projectList", method = RequestMethod.GET)
    public List getProjectsList(Project project) {
        return qualityGateService.getProjects(project);
    }

}
