<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <form method="get" action="prevPage">
        <button>Prev page</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</@c.page>