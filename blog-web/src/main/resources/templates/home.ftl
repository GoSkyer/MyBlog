<#include "common/header.ftl">

<div class="content-body">

    <div class="container">

        <div class="row">

        <#-- 博客文章列表 -->
            <main class="col-md-8">
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
                                <a href="#">
                                    <time class="entry-date"
                                          datetime="2012-11-09T23:15:57+00:00">${item.lastDate?date}</time>
                                </a>
                            </span>
                                 <span class="post-author"><a href="#">${item.userName}</a></span>
                                 <span class="comments-link"><a href="#">${item.commentNum} 评论</a></span>
                                 <span class="views-count"><a href="#">${item.readNum} 阅读</a></span>
                             </div>
                         </header>
                         <div class="entry-content clearfix">
                             <p>${item.description!""}</p>
                             <div class="read-more cl-effect-14">
                                 <a href="/blog/${item.id}" class="more-link">阅读全文 <span class="meta-nav">→</span></a>
                             </div>
                         </div>
                     </article>
                </#list>
            </#if>

                <div class="pagination">
                    <ul>
                        <#if !page.isFirstPage>
                            <li><a href="/home/index?p=1">首页</a></li>
                        </#if>
                        <#if page.hasPreviousPage>
                            <li><a href="/home/index?p=${page.pageNum-1}">上一页</a></li>
                        </#if>
                        <li class="current"><a href="/home/index?p=${page.pageNum}">${page.pageNum}</a></li>
                        <#if page.hasNextPage>
                            <li><a href="/home/index?p=${page.pageNum+1}">下一页</a></li>
                        </#if>
                        <#if !page.isLastPage>
                            <li><a href="/home/index?p=${page.pages}">尾页</a></li>
                        </#if>
                    </ul>
                </div>

            </main><#-- 博客文章列表 -->

            <aside class="col-md-4">

                <div class="widget widget-recent-posts">

                    <h3 class="widget-title">最新文章</h3>
                    <ul>
                        <#if newList??>
                            <#list newList as item>
                                 <li>
                                     <a href="/blog/${item.id}">${item.title}</a>
                                 </li>
                            </#list>
                        </#if>
                    </ul>
                </div>

            <#--<div class="widget widget-archives"></div>-->

                <div class="widget widget-category">
                    <h3 class="widget-title">分类</h3>
                    <ul>
                       <#if groupList??>
                            <#list groupList as item>
                                 <li>
                                     <a href="/content/index?g=${item['id']!""}">${item['name']!""} <span
                                             class="post-count">(${item['count']!"0"})</span></a>
                                 </li>
                            </#list>
                       </#if>
                    </ul>
                </div>

                <div class="widget widget-tag-cloud" hidden>
                    <h3 class="widget-title">标签云</h3>
                    <ul>
                        <li>
                            <a href="#">Django</a>
                        </li>
                        <li>
                            <a href="#">Python</a>
                        </li>
                        <li>
                            <a href="#">Java</a>
                        </li>
                        <li>
                            <a href="#">笔记</a>
                        </li>
                        <li>
                            <a href="#">文档</a>
                        </li>
                        <li>
                            <a href="#">AngularJS</a>
                        </li>
                        <li>
                            <a href="#">CSS</a>
                        </li>
                        <li>
                            <a href="#">JavaScript</a>
                        </li>
                        <li>
                            <a href="#">Snippet</a>
                        </li>
                        <li>
                            <a href="#">jQuery</a>
                        </li>
                    </ul>
                </div>

            </aside>
        </div>
    </div>
</div>

<#include "common/footer.ftl">
