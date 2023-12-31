package delivery.pipeline.inspection.api.qualityIssues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kim on 2017-08-10.
 */
@RestController
@RequestMapping(value = "/qualityIssues")
public class QualityIssuesController {

    private final QualityIssuesService qualityIssuesService;

    @Autowired
    QualityIssuesController(QualityIssuesService qualityIssuesService){
        this.qualityIssuesService = qualityIssuesService;
    }


    /**
     * Get qualityIssues.
     *
     * @return
     */
    @RequestMapping(value = "/qualityIssuesList" , method = RequestMethod.POST)
    public QualityIssues qualityIssuesList(@RequestBody QualityIssues qualityIssues){
        return qualityIssuesService.qualityIssuesList(qualityIssues);
    }

    /**
     * Get projectList.
     *
     * @return
     */
    @RequestMapping(value = "/issuesConditionList" , method = RequestMethod.POST)
    public List<QualityIssues> getIssuesConditionList(@RequestBody QualityIssues qualityIssues){
        return qualityIssuesService.getIssuesConditionList(qualityIssues);
    }


    @RequestMapping(value = "/qualityIssuesDetail", method = RequestMethod.GET)
    public List getQualityIssuesDetail(QualityIssues qualityIssues){
        return qualityIssuesService.getQualityIssuesDetail(qualityIssues);
    }

    @RequestMapping(value = "/setSeverity", method = RequestMethod.POST)
    public Object setSeverity(@RequestBody QualityIssues qualityIssues){
        return qualityIssuesService.setSeverity(qualityIssues);
    }
}
