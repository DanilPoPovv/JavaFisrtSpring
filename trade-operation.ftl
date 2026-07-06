<#include "/settings/settings.ftl">
<#import "/utils/localize-utils.ftl" as localizeUtils>
<#import "/utils/document-utils.ftl" as documentUtils>

<#assign document = document>
<#assign locale = documentLocale>

{
  "elements": [
    <@documentUtils.markAsDuplicate markAsDuplicate/>

    <#include "partials/logo.ftl">

    <#include "partials/taxpayer-info.ftl">
    <#include "partials/document-requisites.ftl">
    <#include "partials/items.ftl">
    <#include "partials/totals.ftl">
    <#include "partials/system-description.ftl">
    <#include "partials/fiscal-sign-qr-code.ftl">

    <@documentUtils.markAsDuplicate markAsDuplicate false/>
  ]
}