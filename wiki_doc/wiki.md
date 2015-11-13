# 登录接口
|版本|修改内容简介|修改日期|修改人|
|----|------------|--------|------|
|1|创建|2015-08-11|田聪|

## 登录接口
### 接口URL
* 线上环境: http://online/Blog/login.do
* 线下环境: http://10.20.17.61/Blog/login.do

### 请求方法
__post__
### 请求参数

|名称|类型|说明|是否必须|
|----|----|----|--------|
|userName|string|用户名|Y|
|password|string|密码|Y|
### 返回参数

|名称|类型|说明|必须存在|
|----|----|----|--------|
|code|string|错误码|Y|
|msg|string|错误信息|Y|
|user|object|用户信息体|Y|


其中*user*里面的字段如下所示:

|名称|类型|说明|必须存在|
|----|----|----|--------|
|nickName|string|用户名|Y|
|phone|string|手机号码|N|
|userName|string|用户名 用户唯一标识|Y|
|email|string|邮箱|N|



### 返回值内容实例

```
{
	"code" : "0",
	"msg" : "Operation Success!",
	"data" : {
		"user" : {
			"nickName" : "Tracy",
			"phone" : "13424303746",
			"userName" : "tiancong",
			"email" : "tiancong@gmail.com",
		}
	}
}
```



## 博客列表接口
### 接口URL
* 线上环境: http://online/Blog/queryArticles.do
* 线下环境: http://10.20.17.61/Blog/queryArticles.do

### 请求方法
__get__
### 请求参数

|名称|类型|说明|是否必须|
|----|----|----|--------|
|pageNumber|string|分页编号|Y|



### 返回参数

|名称|类型|说明|必须存在|
|----|----|----|--------|
|code|string|错误码Y|
|msg|string|错误信息|Y|
|articleInfos|object[]|博客信息|Y|
|pageNumber|String|分页编号|Y|
|totalAmount|String|文章总数|Y|

其中*articleInfos*里面的字段如下所示:

|名称|类型|说明|必须存在|
|----|----|----|--------|
|articleId|string|文章唯一标识|Y|
|titile|string|标题|Y|
|tag|string|标签|Y|
|content|string|内容|Y|
|createTime|string|创建时间|Y|
|updateTime|string|修改时间|Y|
|author|string|作者|Y|

### 返回值内容实例

```
{
	"code" : "0",
	"msg" : "Operation Success!",
	"data" :{
		"acticleInfos" : [
		   {
		   	 “articleId":"147",
		     “titile":"Android Activity",
		     "tag":"android",
		     "content":"Android Activity ",
		     "createTime":"2015-08-11 15:23",
		     "updateTime":"2015-08-12 17:45",
		     "author":"tiancong",
		   }
		],
		"pageNumber":"3",
		"totalAmount":"100",	
	}
}
```

## 插入博客接口
### 接口URL
* 线上环境: http://online/Blog/insertArticle.do
* 线下环境: http://10.20.17.61/Blog/insertArticle.do

### 请求方法
__get__

### 请求参数

|名称|类型|说明|是否必须|
|----|----|----|--------|
|titile|string|标题|Y|
|tag|string|标签|Y|
|content|string|内容|Y|
|userName|string|作者|Y|

### 返回参数

|名称|类型|说明|必须存在|
|----|----|----|--------|
|code|string|错误码<br>|Y|
|msg|string|错误信息|Y|
|decription|string|描述信息|Y|

### 返回值内容实例

```
{
	"code" : "0",
	"msg" : "Operation Success!",
	
}
```
## 修改博客接口
### 接口URL
* 线上环境: http://online/Blog/updateArticle.do
* 线下环境: http://10.20.17.61/Blog/updateArticle.do

### 请求方法
__get__
### 请求参数

|名称|类型|说明|是否必须|
|----|----|----|--------|
|articleId|string|博客唯一标识|Y|
|titile|string|标题|Y|
|tag|string|标签|Y|
|content|string|内容|Y|
|userName|string|用户名|Y|

### 返回参数

|名称|类型|说明|必须存在|
|----|----|----|--------|
|code|string|错误码<br>100,101,102,103|Y|
|msg|string|错误信息|Y|
|decription|string|描述信息|Y|

### 返回值内容实例

```
{
	"code" : "0",
	"msg" : "Operation Success!",
}
```
## 删除博客接口
### 接口URL
* 线上环境: http://online/Blog/deleteArticle.do
* 线下环境: http://10.20.17.61/Blog/deleteArticle.do

### 请求方法
__get__
### 请求参数

|名称|类型|说明|是否必须|
|----|----|----|--------|
|articleId|string|博客唯一标识|Y|
|userName|string|用户名|Y|
### 返回参数

|名称|类型|说明|必须存在|
|----|----|----|--------|
|code|string|错误码<br>104,105,106,110|Y|
|msg|string|错误信息|Y|
|decription|string|描述信息|Y|


### 返回值内容实例

```
{
	"code" : "0",
	"msg" : "Operation Success!",
	
}
```





