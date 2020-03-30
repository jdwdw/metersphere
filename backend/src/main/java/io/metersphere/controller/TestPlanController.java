package io.metersphere.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.metersphere.base.domain.TestCase;
import io.metersphere.base.domain.TestCaseWithBLOBs;
import io.metersphere.base.domain.TestPlan;
import io.metersphere.commons.utils.PageUtils;
import io.metersphere.commons.utils.Pager;
import io.metersphere.controller.request.testcase.QueryTestPlanRequest;
import io.metersphere.dto.TestPlanDTO;
import io.metersphere.service.TestCaseService;
import io.metersphere.service.TestPlanService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/test/plan")
@RestController
public class TestPlanController {

    @Resource
    TestPlanService testPlanService;

    @PostMapping("/list/{goPage}/{pageSize}")
    public Pager<List<TestPlanDTO>> list(@PathVariable int goPage, @PathVariable int pageSize, @RequestBody QueryTestPlanRequest request) {
        Page<Object> page = PageHelper.startPage(goPage, pageSize, true);
        return PageUtils.setPageInfo(page, testPlanService.listTestPlan(request));
    }

    @PostMapping("/get/{testPlanId}")
    public List<TestPlan> getTestPlan(@PathVariable String testPlanId){
        return testPlanService.getTestPlan(testPlanId);
    }

    @PostMapping("/add")
    public void addTestPlan(@RequestBody TestPlan testPlan){
        testPlanService.addTestPlan(testPlan);
    }

    @PostMapping("/edit")
    public void editTestPlan(@RequestBody TestPlan testPlan){
        testPlanService.editTestPlan(testPlan);
    }

    @PostMapping("/delete/{testPlanId}")
    public int deleteTestPlan(@PathVariable String testPlanId){
        return testPlanService.deleteTestPlan(testPlanId);
    }


}
