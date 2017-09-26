为了方便写导出接口，在commonUtils里面加了一个工具类，用来处理导出的功能。

git:
git@202.153.207.179:gamePlat/commonUtils.git

maven:
dependency:
        <groupId>com.babel</groupId>
            <artifactId>lottery-common-utils</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>



关键类:
com.babel.common.utils.excel.ExcelExportUtil
com.babel.common.utils.excel.ExcelExportField:field注解，colNum：指定列，从0开始,   colName:列名，excel的第一行数据

用法示例：
1) 输出row为List<RiskOrderRecordVO>


    /**
     * 方案号
     */
    @ExcelExportField(colNum = 0,colName = "方案编号")
    private String orderId;

	这里表示取orderId是excel输出的第一列，列名是 方案编号，每一行对应位置，会取对应的值写入。这样要添加某一列的时候，可以直接改对象，就不用去修改export的代码

2）关键api:

    public static void download(HttpServletResponse response, List list, String filename) throws IOException {
	list中的对象就是1）中的RiskOrderRecordVO


      if (MapUtils.isNotEmpty(result)) {
            List list = (List) result.get("list");
            if (CollectionUtils.isNotEmpty(list)) {
                String fileName = ExcelExportUtil.formatFileName("风险订单导出");
                try {
                    ExcelExportUtil.download(response, list, fileName);
                } catch (IOException e) {
                    logger.error("listExport::error", e);
                }
            }
        }

可以运行测试用例ExcelUtilTest测试看