-- ----------------------------
-- Records of magic_api_file
-- ----------------------------
INSERT INTO `magic_api_file` VALUES ('magic-api/api/', 'this is directory');
INSERT INTO `magic_api_file` VALUES ('magic-api/api/user/', 'this is directory');
INSERT INTO `magic_api_file` VALUES ('magic-api/api/user/group.json', '{\r\n  \"properties\" : { },\r\n  \"id\" : \"525aaaf542fd4bba8a2d86a09ff5afcb\",\r\n  \"name\" : \"user\",\r\n  \"type\" : \"api\",\r\n  \"parentId\" : \"0\",\r\n  \"path\" : \"user\",\r\n  \"paths\" : [ ],\r\n  \"options\" : [ ]\r\n}');
INSERT INTO `magic_api_file` VALUES ('magic-api/api/user/page.ms', '{\r\n  \"properties\" : { },\r\n  \"id\" : \"62bc8b8e1fd74a7c9680aca2f47a97af\",\r\n  \"script\" : null,\r\n  \"groupId\" : \"525aaaf542fd4bba8a2d86a09ff5afcb\",\r\n  \"name\" : \"page\",\r\n  \"createTime\" : 1649487429985,\r\n  \"updateTime\" : null,\r\n  \"lock\" : null,\r\n  \"createBy\" : null,\r\n  \"updateBy\" : null,\r\n  \"path\" : \"page\",\r\n  \"method\" : \"GET\",\r\n  \"parameters\" : [ ],\r\n  \"options\" : [ ],\r\n  \"requestBody\" : null,\r\n  \"headers\" : [ ],\r\n  \"paths\" : [ ],\r\n  \"responseBody\" : null,\r\n  \"description\" : null,\r\n  \"requestBodyDefinition\" : null,\r\n  \"responseBodyDefinition\" : null\r\n}\r\n================================\r\nreturn db.page(\"\"\"\r\nselect *\r\nfrom user\r\n\"\"\")');
INSERT INTO `magic_api_file` VALUES ('magic-api/datasource/', 'this is directory');
INSERT INTO `magic_api_file` VALUES ('magic-api/function/', 'this is directory');
