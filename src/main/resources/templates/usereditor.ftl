<#import "parts/common.ftl" as c>
<@c.page>
    <form action="/user" method="post">
        <input type="text" name="username" value="${user.getUsername()}"><br>
        <#list roles as role>
            <label><input type="checkbox" name="${role}" ${user.getRoles()?seq_contains(role)?string("checked", "")}>${role}</label>
        </#list>
        <input type="hidden" value="${user.getId()}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</@c.page>