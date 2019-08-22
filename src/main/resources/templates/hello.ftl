<#import "parts/common.ftl" as c>
 <@c.page>
        <form method="get" action="main">
            <button type="submit">Login</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
 </@c.page>