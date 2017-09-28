package paasta.delivery.pipeline.inspection.api.project;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Created by Dojun on 2017-06-19.
 */
public class Project {

    private Long id;
    private String name;

    private String key;
    //자동생성 uuid
    private String sonarKey;

    private String qualifier;
    private String orgName;
    private String orgGuid;
    private String userName;
    private String userGuid;
    private String qualityProfileId;
    private String qualityGateId;
    private String resultStatus;
    private String resultMessage;

    private String branch;

    private String serviceInstancesId;

    //프로젝트와 게이트, 프로파일 연결 상태
    private Boolean linked;

    //sona에서 사용하는 id(gate)
    private String gateId;
    private String projectId;


    //sonar에서 사용하는 id(profile)
    private String profileKey;
    private String projectKey;

    //품질관리 대시보드
    private Object measures;
    private String uuid;
    private String projectName;
    //품질관리 커버리지
    private String resource;
    private List msr;
    private String metrics;
    //tests소스
    private Object baseComponent;
    private String baseComponentKey;
    private List components;
    private List sources;
    private List scm;
    private List issues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgGuid() {
        return orgGuid;
    }

    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }



    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getServiceInstancesId() {
        return serviceInstancesId;
    }

    public void setServiceInstancesId(String serviceInstancesId) {
        this.serviceInstancesId = serviceInstancesId;
    }

    public String getSonarKey() {
        return sonarKey;
    }

    public String getQualityProfileId() {
        return qualityProfileId;
    }

    public void setQualityProfileId(String qualityProfileId) {
        this.qualityProfileId = qualityProfileId;
    }

    public String getQualityGateId() {
        return qualityGateId;
    }

    public void setQualityGateId(String qualityGateId) {
        this.qualityGateId = qualityGateId;
    }

    public void setSonarKey(String sonarKey) {
        this.sonarKey = sonarKey;
    }

    public Boolean getLinked() {
        return linked;
    }

    public void setLinked(Boolean linked) {
        this.linked = linked;
    }

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


    public Object getMeasures() {
        return measures;
    }

    public void setMeasures(Object measures) {
        this.measures = measures;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List getMsr() {
        return msr;
    }

    public void setMsr(List msr) {
        this.msr = msr;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    public Object getBaseComponent() {
        return baseComponent;
    }

    public void setBaseComponent(Object baseComponent) {
        this.baseComponent = baseComponent;
    }

    public String getBaseComponentKey() {
        return baseComponentKey;
    }

    public void setBaseComponentKey(String baseComponentKey) {
        this.baseComponentKey = baseComponentKey;
    }

    public List getComponents() {
        return components;
    }

    public void setComponents(List components) {
        this.components = components;
    }

    public List getSources() {
        return sources;
    }

    public void setSources(List sources) {
        this.sources = sources;
    }

    public List getScm() {
        return scm;
    }

    public void setScm(List scm) {
        this.scm = scm;
    }

    public List getIssues() {
        return issues;
    }

    public void setIssues(List issues) {
        this.issues = issues;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getProfileKey() {
        return profileKey;
    }

    public void setProfileKey(String profileKey) {
        this.profileKey = profileKey;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", sonarKey='" + sonarKey + '\'' +
                ", qualifier='" + qualifier + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgGuid='" + orgGuid + '\'' +
                ", userName='" + userName + '\'' +
                ", userGuid='" + userGuid + '\'' +
                ", qualityProfileId='" + qualityProfileId + '\'' +
                ", qualityGateId='" + qualityGateId + '\'' +
                ", resultStatus='" + resultStatus + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", branch='" + branch + '\'' +
                ", serviceInstancesId='" + serviceInstancesId + '\'' +
                ", linked=" + linked +
                ", gateId='" + gateId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", profileKey='" + profileKey + '\'' +
                ", projectKey='" + projectKey + '\'' +
                ", measures=" + measures +
                ", uuid='" + uuid + '\'' +
                ", projectName='" + projectName + '\'' +
                ", resource='" + resource + '\'' +
                ", msr=" + msr +
                ", metrics='" + metrics + '\'' +
                ", baseComponent=" + baseComponent +
                ", baseComponentKey='" + baseComponentKey + '\'' +
                ", components=" + components +
                ", sources=" + sources +
                ", scm=" + scm +
                ", issues=" + issues +
                '}';
    }


}