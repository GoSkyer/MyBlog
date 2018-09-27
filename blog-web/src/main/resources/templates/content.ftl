<#include "common/header.ftl">

<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-12">
            <#if contentList??>
                <#list contentList as item>
                <article class="post post-1">
                    <header class="entry-header">
                        <h1 class="entry-title">
                            <a href="/blog/${item.id}">${item.title}</a>
                        </h1>
                        <div class="entry-meta">
                            <span class="post-category"><a href="/content/index?g=${item.groupId}">${item.groupName}</a></span>

                            <span class="post-date">
                                <a href="#"><time class="entry-date">${item.lastDate?date}</time></a>
                            </span>

                            <span class="post-author"><a href="#">${item.userName}</a></span>

                            <a href="">${item.commentNum} Comments</a>
                        </div>
                    </header>
                    <div class="entry-content clearfix">
                        <p>${item.description!""}</p>
                        <div class="read-more cl-effect-14">
                            <a href="#" class="more-link">阅读全文 <span class="meta-nav">→</span></a>
                        </div>
                    </div>
                </article>
                </#list>
            </#if>

                <div class="pagination">
                    <ul>

                        <#if !page.isFirstPage>
                            <li><a href="/content/index?p=1<#if groupId gt 0>&g=${groupId}</#if>">首页</a></li>
                        </#if>

                        <#if page.hasPreviousPage>
                            <li><a href="/content/index?p=${page.pageNum-1}">上一页</a></li>
                        </#if>

                        <li class="current">
                            <a href="/content/index?p=${page.pageNum}<#if groupId??>&g=${groupId}</#if><#if tagId??>&t=${tagId}</#if>">${page.pageNum}</a>
                        </li>

                        <#if page.hasNextPage>
                            <li><a href="/content/index?p=${page.pageNum+1}">下一页</a></li>
                        </#if>

                        <#if !page.isLastPage>
                            <li><a href="/content/index?p=${page.pages}">尾页</a></li>
                        </#if>

                    </ul>
                </div>

            </main>
        </div>
    </div>
</div>

<#include "common/footer.ftl">
