<#import "parts/common.ftl" as c>

<@c.page>
    List of users:
    <#list users as user>
        <b>Name:</b> ${user.getUsername()}<br>
        <b>User id: </b> ${user.getId()}<br>
        <b>Roles:</b> <#list user.getRoles() as role>${role} | </#list><br>
        <form action="/user/${user.getId()}"><button type="submit">Edit user</button></form><br><br>

    </#list>
    <a href="/main">Back</a>
</@c.page>