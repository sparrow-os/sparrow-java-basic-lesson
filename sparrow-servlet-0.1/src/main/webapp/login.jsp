<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录-麻雀窝</title>
    <link rel="stylesheet" type="text/css" href="http://r.sparrowzoo.net/styles/pure-css/pure-min.css?v=1.0"/>
    <!--[if lte IE 8]>
    <link rel="stylesheet" type="text/css" href="http://r.sparrowzoo.net/styles/layouts-old-ie.css?v=1.0"/>
    <![endif]-->
    <!--[if gt IE 8]><!-->
    <link rel="stylesheet" type="text/css" href="http://r.sparrowzoo.net/styles/layouts.css?v=1.0"/>
    <!--<![endif]-->
    <link rel="stylesheet" type="text/css" href="http://r.sparrowzoo.net/styles/sparrow.css?v=1.0"/>
    <script language="javascript" type="text/javascript"
            src="http://r.sparrowzoo.net/scripts/sparrow.js?v=1.0"></script>
    <script language="javascript" type="text/javascript"
            src="http://r.sparrowzoo.net/ext/scripts/system/language/zh_cn/user.js?v=1.0"></script>
</head>
<body>

<div class="header">
    <h1>麻雀窝用户登录</h1>
    <h2>
        还没有帐号?
        <a href="http://passport.sparrowzoo.com/register">立即注册</a>
    </h2>
</div>

<div class="content">
    <form action="/login" method="post" class="pure-form pure-form-aligned">
        <fieldset>
            <div class="pure-control-group">
                <label for="txtUserName">
                    用户名
                </label>
                <input type="text" id="txtUserName" name="userName" class="input"
                       onfocus='$.v.showMessage(loginInfo,this);' onblur='$.v.isNull(loginInfo,this);'/>
                <span id="errorUserName" name="login_user_name" class="error"></span>
            </div>
            <div class="pure-control-group">
                <label>
                    密 码
                </label>
                <input class="input" type="password"
                       onfocus="$.v.showMessage(loginInfo,this);"
                       onblur="$.v.isNull(loginInfo,this);" id="txtPassword"
                       name="password"/>
                <span id="errorPassword" name="login_password" class="error"></span>
            </div>
            <div class="pure-control-group">
                <label>
                    验证码
                </label>
                <input class="input" onfocus="$.v.showMessage(loginInfo,this);"
                       onblur="$.v.isNull(loginInfo,this);" type="text"
                       maxlength="4" name="validateCode" id="txtValidateCode"/>

                <img id="imgLoginValidateCode"
                     onclick="$(this).fresh()" src="/ValidateCode"/>
                <a href="javascript:$('#imgLoginValidateCode').fresh();"> 看不清 换一张</a>
                <span id="errorValidateCode" name="login_validate_code" class="error"></span>
            </div>

            <div class="pure-controls">
                <label for="chbLoginDays" class="pure-checkbox">
                    <input id="chbLoginDays" value="14" name="loginDays" type="checkbox"> 两周直接登录(家庭登录模式)<a
                        href="http://passport.sparrowzoo.com/password/find-by-email">忘记密码</a><br/>
                    <span class="highlight">温馨提示</span>为了您的密码安全,如果您在网吧等公共场所请不要勾选此项
                </label>

                <button onenter="true" type="button" onclick="$.v.getValidateResult(loginInfo);"
                        class="pure-button pure-button-primary">登录
                </button>
            </div>
        </fieldset>
        <input type="hidden" name="redirectUrl" value=""/>
    </form>
</div>
</body>
</html>
