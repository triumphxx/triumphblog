<#include "include/macro.ftl"/>

<@layout "首页">

<#include "include/header-panel.ftl"/>

<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
            <div class="fly-panel">
                <div class="fly-panel-title fly-filter">
                    <a>置顶</a>
                </div>
                <ul class="fly-list">
                    <#list pageData.records as post>
                        <@plisting post></@plisting>
                    </#list>
                </ul>
            </div>

            <div class="fly-panel" style="margin-bottom: 0;">

                <div class="fly-panel-title fly-filter">
                    <a href="" class="layui-this">综合</a>
                    <span class="fly-mid"></span>
                    <a href="">未结</a>
                    <span class="fly-mid"></span>
                    <a href="">已结</a>
                    <span class="fly-mid"></span>
                    <a href="">精华</a>
                    <span class="fly-filter-right layui-hide-xs">
            <a href="" class="layui-this">按最新</a>
            <span class="fly-mid"></span>
            <a href="">按热议</a>
          </span>
                </div>

                <ul class="fly-list">
                    <#list pageData.records as post>
                        <@plisting post></@plisting>
                    </#list>
                </ul>
                <#--分页-->
                <@pagaing pageData></@pagaing>
            </div>
        </div>

        <#include "include/right.ftl" />
    </div>
</div>

</@layout>