<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.login "/login" />
    <a href="/registration">Sign up</a>
</@c.page>