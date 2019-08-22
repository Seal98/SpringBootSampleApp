<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    ${message?if_exists}
    Create new user:
<@l.login "/registration" />
</@c.page>