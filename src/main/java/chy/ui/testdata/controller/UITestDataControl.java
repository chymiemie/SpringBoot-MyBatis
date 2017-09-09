package chy.ui.testdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import chy.ui.testdata.dao.ChytestdataMapper;
import chy.ui.testdata.model.Chytestdata;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/dal")
@Api(value = "UI测试数据接口", tags = { "testdata" })
public class UITestDataControl {

	@Autowired
	private ChytestdataMapper chytestdataMapper;

	/**
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询所有测试记录", notes = "获取所有测试数据")
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = { "application/json" })
	public String getTestdata() {
		List<Chytestdata> chytestdatas = chytestdataMapper.selectAll();
		return JSON.toJSONString(chytestdatas);
	}

	@ApiOperation(value = "根据id更新测试记录", notes = "更新id相应的测试记录")
	@RequestMapping(value = "/update", method = RequestMethod.PUT,consumes = { "application/json" }, produces = {
	"application/json" })
	public String updateTestdata(
			@ApiParam(required = true, name = "更新测试数据", value = "updatetestdata") @RequestBody Chytestdata chytestdata) {
		int j = chytestdataMapper.updateTestdata(chytestdata);
		System.out.println(j);
		return JSON.toJSONString(chytestdataMapper.updateTestdata(chytestdata));
	}

	@ApiOperation(value = "删除测试记录", notes = "删除相应的测试记录")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteTestdata(
			@ApiParam(required = true, name="id",value="主键ID") @RequestParam int id) {
		int k = chytestdataMapper.deleteByID(id);
		System.out.println(k);
		return JSON.toJSONString(chytestdataMapper.deleteByID(id));
	}

}
