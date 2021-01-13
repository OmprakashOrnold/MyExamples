package com.aldrich.jsoup;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.patent.SSLExceptionSolution;

public class CompanyUrlCheck {

	public static void main(String[] args) {

		List<String> url=new ArrayList<String>();

		url.add("	https://www3.technologyevaluation.com/sd/category/document-management-dms	");
		url.add("	https://www.epc.co.uk/media-centre/blog/item/what-is-the-business-process-management-bpm-lifecycle	");
		url.add("	https://www.aiim.org/What-is-BPM	");
		url.add("	https://www.oreilly.com/library/view/what-is-bpm/9780071802253/chapter4.html	");
		url.add("	https://bpm.com/what-is-bpm	");
		url.add("	https://searchcio.techtarget.com/definition/business-process-management	");
		url.add("	https://www.cflowapps.com/business-process-management/	");
		url.add("	https://www.emerald.com/insight/content/doi/10.1108/14637159710161585/full/html	");
		url.add("	https://www.villanovau.com/resources/bpm/business-process-manager/	");
		url.add("	https://www.trustradius.com/business-process-management-bpm	");
		url.add("	https://www.ibm.com/cloud/automation-software/business-process-management	");
		url.add("	https://enterprisersproject.com/article/2020/11/business-process-management-bpm-explained	");
		url.add("	https://www.flowwright.com/business-process-management	");
		url.add("	https://link.springer.com/chapter/10.1007/978-3-642-33143-5_1	");
		url.add("	https://www.visionet.com/business-process-management/	");
		url.add("	https://www.g2.com/categories/business-process-management	");
		url.add("	https://www.abpmp.org/	");
		url.add("	https://www.ipmcinc.com/services/business-process-management/	");
		url.add("	https://www.opentext.com/products-and-solutions/products/digital-process-automation/business-process-management-bpm	");
		url.add("	https://www.sciencedirect.com/science/article/pii/S0268401215001000	");
		url.add("	https://www.bpminstitute.org/resources/articles/what-bpm-anyway-business-process-management-explained	");
		url.add("	https://www.ariscommunity.com/business-process-management	");
		url.add("	https://www.routledge.com/Business-Process-Management/Kumar/p/book/9781138181854	");
		url.add("	https://webcon.com/solutions-business-process-management/	");
		url.add("	https://www.udemy.com/topic/business-process-management/	");
		url.add("	http://www.omg.org/bpmn/Documents/6AD5D16960.BPMN_and_BPM.pdf	");
		url.add("	https://www.zoho.com/creator/business-process-management.html	");
		url.add("	https://www.predictiveanalyticstoday.com/what-is-business-process-management-software/	");
		url.add("	https://economictimes.indiatimes.com/topic/Business-process-management	");
		url.add("	https://getsix.eu/resources/glossary/the-benefits-of-business-process-management/	");
		url.add("	https://www.stakeholdermap.com/bpm/bpm.html	");
		url.add("	https://retransform.com/business-process-management/	");
		url.add("	https://thedigitalprojectmanager.com/bpms-bpm-software/	");
		url.add("	https://www.heflo.com/definitions/business-process-management-suite-bpms/	");
		url.add("	https://www.softwaretestinghelp.com/best-document-management-systems/	");
		url.add("	https://www.openkm.com/	");
		url.add("	https://www.softwaresuggest.com/document-management-software	");
		url.add("	https://in.pcmag.com/cloud-services/95757/the-best-document-management-software-for-2020	");
		url.add("	https://www.efilecabinet.com/what-is-a-document-management-system/	");
		url.add("	https://www.businessnewsdaily.com/8038-best-document-management-software.html	");
		url.add("	https://www.krystaldms.in/	");
		url.add("	https://www.quicksprout.com/best-document-management-software/	");
		url.add("	http://www.docmanager.co.in/	");
		url.add("	https://www.techradar.com/in/best/best-document-management-software	");
		url.add("	https://www.goodfirms.co/blog/best-free-open-source-document-management-software	");
		url.add("	https://www.thebalancesmb.com/creating-a-document-management-system-2948084	");
		url.add("	https://www.nuxeo.com/products/document-management/	");
		url.add("	https://www.docprodms.com/products/document-management-system/	");
		url.add("	http://www.cr2.in/products/products-docmanager.html	");
		url.add("	https://www3.technologyevaluation.com/sd/category/document-management-dms	");
		url.add("	https://www.customshow.com/document-management-software-tools/	");
		url.add("	https://blog.bit.ai/document-management-systems/	");
		url.add("	https://www.stockholdingdms.com/product.php?id=17	");
		url.add("	https://dir.indiamart.com/impcat/document-management-system.html	");
		url.add("	https://www.betterbuys.com/dms/	");
		url.add("	https://www.cognidox.com/blog/what-is-electronic-document-management-system	");
		url.add("	https://www.sharedocsdms.com/	");
		url.add("	https://www.netlabindia.com/our-solutions/office-automation/document-management/	");
		url.add("	https://financesonline.com/top-15-document-management-systems/	");
		url.add("	https://eisenvault.com/	");
		url.add("	https://naviant.com/document-management-software/	");
		url.add("	https://en.ennov.com/ennov-quality-management-system-qms/ennov-doc-for-quality/	");
		url.add("	https://www.ricohdocs.com/	");
		url.add("	https://www.canon-europe.com/For_Work/my-business/office/document-management/	");
		url.add("	https://idoc.co.in/	");
		url.add("	https://www.industries.veeva.com/document-management-solutions	");
		url.add("	https://www.docusoft.net/	");
		url.add("	https://www.docuvity.com/	");
		url.add("	https://www.cmswire.com/information-management/how-document-management-and-content-management-differ/	");
		url.add("	https://www.gdata.in/information-management/document-management-solutions	");
		url.add("	https://www.techjockey.com/category/document-management-software	");
		url.add("	http://info.docuvantage.com/blog/creating-a-document-management-strategy-for-your-organization	");
		url.add("	https://www.doclogix.com/solutions/office-management-solution/	");
		url.add("	https://www.accesscorp.com/en-ca/document-management-software/	");
		url.add("	https://tax.thomsonreuters.com/en/accounting-solutions/electronic-document-management	");
		url.add("	https://www.damcogroup.com/Insurance/Document-Management-Software.html	");
		url.add("	http://www.rincon.co.in/site/solutions/document-management/	");
		url.add("	https://www.cosmoconsult.com/products/collaboration-solutions/document-management/	");
		url.add("	http://www.adrenotechnologies.com/document-management-services.php	");
		url.add("	https://www.templafy.com/enterprise-document-management/	");
		url.add("	https://www.docsvault.com/features/document-management-system-security/	");
		url.add("	https://in.canon/en/business/products/search?category=software	");
		url.add("	https://www.softwareworld.co/document-management-software/	");
		url.add("	https://ungoti.com/blog/why-sharepoint-best-document-management-system/	");
		url.add("	https://highbartechnocrat.com/document-management-solution-dms/	");
		url.add("	https://resolving.com/document-management-solutions	");
		url.add("	https://www.opendocman.com/	");
		url.add("	https://searcherp.techtarget.com/definition/financial-analytics#:~:text=Financial%20analytics%20is%20the%20creation,factual%20insight%20rather%20than%20intuition.	");
		url.add("	https://www.upgrad.com/blog/data-science-use-cases-finance-industry/	");
		url.add("	https://www.bls.gov/ooh/business-and-financial/mobile/financial-analysts.htm	");
		url.add("	https://www.educba.com/financial-analytics/	");
		url.add("	https://www.coursera.org/courses?query=financial%20analytics	");
		url.add("	https://www2.deloitte.com/content/dam/Deloitte/global/Documents/Deloitte-Analytics/dttl-analytics-us-da-3minFinanceAnalytics.pdf	");
		url.add("	https://www.readyratios.com/reference/analysis/	");
		url.add("	https://corporatefinanceinstitute.com/resources/knowledge/finance/types-of-financial-analysis/	");
		url.add("	https://www.stevens.edu/school-business/masters-programs/financial-analytics	");
		url.add("	https://analyticstraining.com/building-a-career-in-financial-analytics/	");
		url.add("	https://talentedge.com/xlri-jamshedpur/financial-analytics-course/	");
		url.add("	https://www.financialexecutives.org/FEI-Daily/June-2020/What-Does-the-Future-of-Finance-Analytics-Look-Lik.aspx	");
		url.add("	https://www.spjimr.org/content/financial-analytics	");
		url.add("	https://www.thoughtspot.com/solutions/financial-analytics	");
		url.add("	https://vil.xlri.ac.in/course/edp-in-financial-analytics/	");
		url.add("	https://www.teradata.jp/Glossary/What-is-Finance-Analytics	");
		url.add("	https://360digitmg.com/india/certification-program-in-financial-analytics	");
		url.add("	https://www.sisense.com/solutions/finance/	");
		url.add("	https://www.marketsandmarkets.com/Market-Reports/financial-analytics-market-1303.html	");
		url.add("	https://www.forbes.com/sites/bernardmarr/2016/04/07/6-key-financial-analytics-every-manager-should-know/	");
		url.add("	https://www.solvexia.com/blog/5-reasons-financial-analytics-is-the-new-weapon-for-cfos	");
		url.add("	https://www.datacamp.com/courses/financial-analytics-in-spreadsheets	");
		url.add("	https://online.stanford.edu/programs/financial-analytics-graduate-certificate	");
		url.add("	https://www.mordorintelligence.com/industry-reports/financial-analytics-market	");
		url.add("	https://in.linkedin.com/jobs/financial-analytics-jobs	");
		url.add("	https://www.ifheindia.org/dlp/Financial-Analytics.html	");
		url.add("	https://www.brandeis.edu/global/academics/msba/curriculum/financial-analytics.html	");
		url.add("	https://www.henryharvin.com/financial-analytics-course-with-r	");
		url.add("	https://udallas.edu/analytics/index.html	");
		url.add("	https://mileseducation.com/finance/iim-lucknow/finance-analytics	");
		url.add("	https://www.cambridge.org/financialanalytics	");
		url.add("	https://www.trentu.ca/amod/program/financial-analytics-msc	");
		url.add("	https://www.quantzig.com/blog/benefits-financial-analytics-software	");
		url.add("	https://expressanalytics.com/blog/growing-role-of-finance-analytics-in-banking-5222018/	");
		url.add("	https://www.amazon.in/Financial-Analytics-Building-Laboratory-Science/dp/1107150752	");
		url.add("	https://www.jmi.ac.in/aboutjamia/departments/Economics/courses-name/Master_of_Science_in_Banking_and_Financial_Analytics-636/1	");
		url.add("	http://sersc.org/journals/index.php/IJAST/article/view/22651	");
		url.add("	https://www.digitalistmag.com/finance/2018/04/12/emerging-trends-in-financial-analytics-06066122/	");
		url.add("	https://blog.iilm.edu/future-financial-analytics/	");
		url.add("	https://www.dbs.ie/course/postgraduate/master-of-science-(msc.)-in-financial-analytics	");
		url.add("	https://www.worldscientific.com/worldscibooks/10.1142/10555	");
		url.add("	https://www.futuremarketinsights.com/reports/financial-analytics-market	");
		url.add("	http://courses.ncirl.ie/index.cfm/page/module/moduleId/21125	");
		url.add("	https://www.persistencemarketresearch.com/market-research/financial-analytics-market.asp	");
		url.add("	https://journalofbigdata.springeropen.com/articles/10.1186/s40537-019-0209-0	");
		url.add("	https://chiselanalytics.com/why-financial-analytics-is-failing-your-business/	");
		url.add("	https://www.findamasters.com/masters-degrees/?Keywords=financial+analytics	");
		url.add("	http://fainstitute.com/	");
		url.add("	https://www.2sconsulting.com/solutions/financial-analytics	");
		url.add("	https://blink.ucsd.edu/technology/bi/sources/financial-analytics/index.html	");
		url.add("	https://www.kcl.ac.uk/study/postgraduate/taught-courses/finance-analytics-msc	");
		url.add("	https://bostonfagroup.com/financial-analytics/	");
		url.add("	https://www.inkwoodresearch.com/reports/global-financial-analytics-market-forecast-2019-2027/	");
		url.add("	https://visagio.com/en/insights/financial-analytics-driving-organisations-financial-health	");
		url.add("	https://www.researchgate.net/publication/332142274_FINANCIAL_ANALYTICS	");
		url.add("	https://industryarc.com/Report/15406/financial-analytics-market.html	");
		url.add("	https://www.mastersportal.com/studies/287286/financial-analytics.html	");
		url.add("	https://www.analyticssteps.com/blogs/introduction-financial-analysis	");
		url.add("	https://www.truity.com/career-profile/financial-analyst	");
		url.add("	https://www.wayup.com/guide/what-is-a-financial-analyst/	");
		url.add("	https://businesstoys.in/programs/financial-analyst-certification-program	");
		url.add("	https://www.ivey.uwo.ca/msc/courses/financial-analytics/	");
		url.add("	https://www.rit.edu/study/accounting-and-financial-analytics-adv-cert	");
		url.add("	https://www.shiksha.com/college/christ-lavasa-pune-campus-mulshi-38868/course-b-com-in-financial-analytics-435037	");
		url.add("	https://www.accountsjunction.com/financial-analytics	");
		url.add("	https://www.envisionecommerce.com/enhance-your-ecommerce-business-by-business-intelligence-and-financial-analytics-in-the-age-of-cloud-accounting/	");
		url.add("	https://www.quora.com/What-do-you-learn-in-financial-analytics	");
		url.add("	https://www.researchoptimus.com/business-analytics/financial.php	");
		url.add("	http://www.dhiomics.com/financial-analytics	");
		url.add("	https://www3.fundsforngos.org/financial-management/2-what-is-financial-management/#:~:text=Financial%20Management%20is%20a%20vital,achieve%20organizational%20goals%20and%20objectives.	");
		url.add("	https://wikifinancepedia.com/finance/financial-management-definition-examples	");
		url.add("	https://www.economicsdiscussion.net/financial-management/types-of-financial-decisions-in-financial-management/31652	");
		url.add("	https://samples.jbpub.com/9780763778941/78941_02_CH01_001_010.pdf	");
		url.add("	https://www.managementstudyguide.com/financial-management.htm	");
		url.add("	https://www.toppr.com/guides/business-environment/business-functions/financial-management/	");
		url.add("	https://managementhelp.org/businessfinance/index.htm	");
		url.add("	https://www.lsbf.org.uk/blog/news/importance-of-financial-management/117410	");
		url.add("	https://www.yourarticlelibrary.com/financial-management/financial-management-its-definition-meaning-and-objectives-discussed/27963	");
		url.add("	https://www.5minutefinance.org/concepts/goal-of-financial-management	");
		url.add("	https://www.worldbank.org/en/programs/financial-management	");
		url.add("	http://www.unoy.org/evaluationguide/learning/for-organisations/financial-management/	");
		url.add("	https://courses.lumenlearning.com/boundless-business/chapter/introduction-to-financial-management/	");
		url.add("	https://efinancemanagement.com/financial-management	");
		url.add("	https://onlinelibrary.wiley.com/journal/1755053x	");
		url.add("	https://www.managementstudyhq.com/financial-management-meaning-objectives-functions.html	");
		url.add("	https://nptel.ac.in/courses/110/107/110107144/	");
		url.add("	https://www.pfh-university.com/blog/financial-management-what-is-it-and-why-is-it-important.html	");
		url.add("	https://www.icai.org/post.html?post_id=14365	");
		url.add("	https://www.edx.org/learn/financial-management	");
		url.add("	https://www.naukri.com/financial-management-jobs	");
		url.add("	https://www.mdpi.com/journal/jrfm	");
		url.add("	https://exinfm.com/training/	");
		url.add("	https://distance.nmims.edu/programs/pgdbm-financial-management/	");
		url.add("	https://doe.gov.in/page_nifm	");
		url.add("	http://nifm.ac.in/	");
		url.add("	https://gsdrc.org/professional-dev/public-financial-management/	");
		url.add("	https://www.skillsyouneed.com/rhubarb/personal-financial-management.html	");
		url.add("	https://blog.workday.com/en-us/2020/understanding-the-basics-what-is-a-financial-management-system.html	");
		url.add("	https://wiki.en.it-processmaps.com/index.php/Financial_Management	");
		url.add("	https://hbr.org/topic/financial-management	");
		url.add("	https://ifms.raj.nic.in/	");
		url.add("	https://www.accaglobal.com/in/en/qualifications/glance/certificate-in-public-financial-management/course-details.html	");
		url.add("	https://elearning.scranton.edu/resource/business-leadership/business-financial-management-for-beginners	");
		url.add("	https://phap.org/theme-financial-management	");
		url.add("	https://www.wikiaccounting.com/what-is-financial-management/	");
		url.add("	https://www.journals.elsevier.com/journal-of-multinational-financial-management	");
		url.add("	https://www.academiccourses.com/Courses/Financial-Management/	");
		url.add("	https://www.indiaeducation.net/management/streams/finance-management.aspx	");
		url.add("	https://byjus.com/commerce/scope-of-financial-management/	");
		url.add("	https://businessjargons.com/financial-management.html	");
		url.add("	https://pfms.nic.in/	");
		url.add("	https://collegegrad.com/careers/financial-managers	");
		url.add("	https://www.humentum.org/training/financial-management	");
		url.add("	https://www.tbs-education.com/program/msc-international-financial-management-and-control/	");
		url.add("	https://www.fmsfindia.org.in/	");
		url.add("	https://www.careerexplorer.com/careers/financial-manager/	");
		url.add("	https://www.jstor.org/journal/finamana	");
		url.add("	https://www.jagranjosh.com/careers/financial-management-1528695599-1	");
		url.add("	https://www.indiatoday.in/education-today/jobs-and-careers/story/financial-management-career-options-359202-2016-12-23	");
		url.add("	https://www.nibusinessinfo.co.uk/content/ten-top-tips-improve-your-financial-management	");
		url.add("	https://smallbusiness.chron.com/key-concepts-financial-management-60904.html	");
		url.add("	https://www.gisma.com/course/master-of-science-corporate-financial-management	");
		url.add("	https://www.welingkar.org/programmes/part-time-programme/mumbai/masters-in-financial-management	");
		url.add("	https://www.businessmanagementideas.com/essays/financial-management-essays/essay-on-financial-management/6026	");
		url.add("	https://hsc.co.in/what-is-financial-management-state-its-role-in-the-organization/	");
		url.add("	https://www.masterstudies.com/Masters-Degree/Financial-Management/	");
		url.add("	http://www.publishingindia.com/ijfm/	");
		url.add("	https://www.tutorialspoint.com/what-is-financial-management-define-objectives-and-scope-of-financial-management	");
		url.add("	https://tallysolutions.com/business-guides/importance-of-financial-management/	");
		url.add("	http://www.fao.org/3/U2200E/u2200e09.htm	");
		url.add("	https://www.imf.org/en/Capacity-Development/Training/ICDTC/Courses/PFMx	");
		url.add("	https://collegedunia.com/courses/diploma-in-financial-management	");
		url.add("	https://templates.office.com/en-us/financial-management	");
		url.add("	https://www.vedantu.com/commerce/scope-of-financial-management	");
		url.add("	http://mdudde.net/pdf/study_material_DDE/Mcom/Mcom-f/FinancialManagement.pdf	");
		url.add("	https://www.td.org/insights/5-basic-financial-skills-every-manager-should-have	");
		url.add("	https://saylordotorg.github.io/text_international-business/s19-04-financial-management-in-intern.html	");
		url.add("	https://nhm.gov.in/index4.php?lang=1&level=0&linkid=354&lid=441	");
		url.add("	https://onlinecourses.swayam2.ac.in/cec20_mg05/preview	");
		url.add("	https://us.sagepub.com/en-us/nam/financial-management/book253193	");
		url.add("	https://home.kpmg/in/en/home/services/advisory/management-consulting/financial-management.html	");
		url.add("	https://smude.edu.in/smude/programs/bba/financial-management.html	");
		url.add("	https://www.ibm-institute.com/financial-management-program/	");
		url.add("	https://www.eruditus.com/india/programmes/professional-certificate-programme-in-financial-analysis-and-financial-management/	");
		url.add("	https://www.accountingdepartment.com/blog/bid/381999/Finding-the-Perfect-Accounting-Solution	");
		url.add("	https://www.pwbcpas.com/services/accounting-solutions/	");
		url.add("	https://www.northeastern.edu/bachelors-completion/news/what-does-an-accountant-do/	");
		url.add("	https://www.kpi.com/online-accounting-solution/	");
		url.add("	http://www.accountingsolutionsnd.com/	");
		url.add("	https://vaderanco.com/solution/accounting-solutions/	");
		url.add("	https://blog.hubspot.com/sales/small-business-accounting-software	");
		url.add("	https://www.acecloudhosting.com/blog/top-5-accounting-solutions-for-small-businesses/	");
		url.add("	https://www.pkf.com/services/business-solutions/	");
		url.add("	https://accounting.cfotechoutlook.com/vendors/top-accounting-solution-providers-2018.html	");
		url.add("	https://www.analytixaccounting.com/	");
		url.add("	https://asl.co.nz/	");
		url.add("	https://www.pcmag.com/picks/the-best-small-business-accounting-software	");
		url.add("	https://blog.hubstaff.com/cloud-accounting-solutions/	");
		url.add("	https://www.murex.com/solutions/business-functions/enterprise-operations-and-finance/mx3-hedge-accounting	");
		url.add("	https://www.botkeeper.com/blog/ebook-the-accountants-guide-to-selecting-an-automated-accounting-solution	");
		url.add("	https://www.pwc.in/consulting/pwc-tabulate/a-simple-and-real-time-accounting-solution.html	");
		url.add("	https://www.sulekha.com/complete-accounting-solution-kaloor-cochin-contact-address	");
		url.add("	https://www.topperlearning.com/t-s-grewal-solutions/cbse-class-11-commerce-accountancy/financial-accounting	");
		url.add("	https://www.fortisaccountingsolutions.com/	");
		url.add("	https://www.zaubacorp.com/company/CAPIUM-SMART-ACCOUNTING-SOLUTIONS-PRIVATE-LIMITED/U72900TG2018FTC122016	");
		url.add("	https://www.hospitalitynet.org/organization/17016174/professional-accounting-solutions-inc-pas.html	");
		url.add("	https://www.ncert-solutions.com/ts-grewal-accountancy-class-11-solutions/	");
		url.add("	https://www.summitaccountingsolutions.com/	");
		url.add("	https://conseroglobal.com/solution/	");
		url.add("	https://www.asp-nw.com/	");
		url.add("	https://www.accountancyknowledge.com/accounting-problems-and-solutions/	");
		url.add("	https://www.deskerra.com/	");
		url.add("	https://www.statestreet.com/solutions/by-capability/ssgs/invest-service/accounting.html	");
		url.add("	https://www.pearaccountingsolutions.com/	");
		url.add("	https://www.tcsion.com/dotcom/iONHelp/Finance%20and%20Accounting/	");
		url.add("	https://www.solve.ie/	");
		url.add("	https://www.capactix.com/	");
		url.add("	https://myaccounts.in/	");
		url.add("	https://www.accountssolutions.org/	");
		url.add("	https://www.learncbse.in/ncert-solutions-for-class-12-accountancy/	");
		url.add("	https://www.moodysanalytics.com/solutions-overview/regulatory-accounting	");
		url.add("	https://m.economictimes.com/small-biz/sme-sector/how-cloud-based-accounting-solution-can-fight-coronavirus-lockdown/articleshow/74907323.cms	");
		url.add("	https://kmaccounts.com/	");
		url.add("	https://www.indiamart.com/accfin-solutions/	");
		url.add("	https://scanbot.io/en/sdk/industries/accounting-scanner-sdk	");
		url.add("	https://www.startus-insights.com/innovators-guide/5-top-emerging-carbon-accounting-solutions/	");
		url.add("	http://gdas-dams.com/contact_us.html	");
		url.add("	https://www.diligen.in/	");
		url.add("	https://solutionsforaccounting.co.uk/	");
		url.add("	https://www.accsoln.com/	");
		url.add("	https://www.betteraccountingsolutions.com/	");
		url.add("	https://www.kaizenacct.com/	");
		url.add("	https://www.cpapracticeadvisor.com/home/article/10263076/the-evolution-of-technology-for-the-accounting-profession	");
		url.add("	https://www.accountingsolutionhull.com/	");
		url.add("	https://www.plantemoran.com/how-we-can-help/services/finance-and-accounting-solutions	");
		url.add("	https://www.placementindia.com/job-recruiters/global-disbursement-accounting-solutions-pvt-ltd-hyderabad-681941-ffid/	");
		url.add("	https://yourstory.com/smbstory/digital-playbook-smbs-small-businesses-msme-accounting-solutions	");
		url.add("	https://www.advisorkhoj.com/advisor/Varanasi/Online-Tax-Return-Filing/Accounting-Solution-%3Cnear%3EVaranasi-City	");
		url.add("	https://www.walsh-accounting.com/	");
		url.add("	https://www.carisma-solutions.com.au/	");
		url.add("	http://www.globaldasolutions.com/	");
		url.add("	https://www.groforth.com/advantages-and-disadvantages-of-cloud-based-accounting/	");
		url.add("	https://restaurantaccountingsolution.com/	");
		url.add("	http://www.allbankingsolutions.com/top-topics/aboutus.shtml	");
		url.add("	https://www.nelito.com/blog/what-is-core-banking-solution.html	");
		url.add("	https://localfirstbank.com/article/four-different-types-of-services-banking/	");
		url.add("	https://www.pass-consulting.com/en/industries/banking/	");
		url.add("	https://finezza.in/blog/core-banking-solution/	");
		url.add("	https://www.edgeverve.com/finacle/direct-banking-solution/	");
		url.add("	https://www.softwaregroup.com/industry/banks	");
		url.add("	https://arttha.com/digital-banking	");
		url.add("	https://www.servicenow.co.uk/solutions/industry/financial-services/banking.html	");
		url.add("	https://www.profilesw.com/en/banking.php	");
		url.add("	https://www.finastra.com/solutions/retail-banking/retail-digital-solutions	");
		url.add("	https://www.ndtv.com/topic/banking-solutions	");
		url.add("	http://www.modelbank.in/index.php/en/core-banking-solution	");
		url.add("	https://www.bobsguide.com/guide/prod/5-9667-finacle-core-banking-solution.html	");
		url.add("	https://www.infovision.com/nxtgen-ilab/smart-banking-solution/	");
		url.add("	http://bangaloreicai.org/images/icons/ITT/4.%20Core%20Banking%20Solution.pdf	");
		url.add("	https://www.vsoft.co.in/core-banking/	");
		url.add("	https://www.digipay.guru/agency-banking-solutions/	");
		url.add("	https://www.veripark.com/industries/retail-banking	");
		url.add("	https://www.igcb.com/insights/resources/cs-central-banks.html	");
		url.add("	https://ebseg.com/Digital-Banking.html	");
		url.add("	http://www.listspl.co.in/custodian-core-banking-solution.html	");
		url.add("	https://www.nousinfosystems.com/industries/banking-and-finance-services	");
		url.add("	https://www.allerin.com/industry/banking-solution	");
		url.add("	https://www.hikvision.com/en/solutions/solutions-by-industry/banking/	");
		url.add("	http://www.experienceinfosys.com/mobile-banking	");
		url.add("	https://www.matellio.com/blog/top-10-core-banking-solutions-2020/	");
		url.add("	https://www.birlasoft.com/industries/banking/case-studies/indian-banking-major-implements-real-time-banking-solution-for-best-in-class-customer-experience	");
		url.add("	https://www.comarch.com/finance/banking/	");
		url.add("	https://www.esds.co.in/blog/what-exactly-is-core-banking/	");
		url.add("	https://www.codebtech.com/core-banking-solutions/	");
		url.add("	https://lunetta.in/Core-Banking-Solution	");
		url.add("	http://www.datavsn.com/products-and-services/data-mate-core-banking-solution	");
		url.add("	https://www.trustbankcbs.com/	");
		url.add("	https://sil.co.in/swiftcore-total-banking-solution/	");
		url.add("	https://apps.nic.in/apps/government/co-operative-core-banking-solution-ccbs	");
		url.add("	https://solutionportfolio.net.sap/industry/BANK	");
		url.add("	https://cedge.in/core-banking-solution/	");
		url.add("	https://www.peerbits.com/agency-banking-solutions.html	");
		url.add("	https://vgipl.com/e-banker-core-banking-solution/	");
		url.add("	https://www.computerweekly.com/news/1508430/SBIs-core-banking-solution-success-story	");
		url.add("	https://www.techmahindra.com/en-in/banking-financial-services-and-insurance/core-banking/	");
		url.add("	https://www.antiersolutions.com/crypto-banking-solution/	");
		url.add("	http://www.virmati.com/Islamic-Banking.html	");
		url.add("	https://www.coforgetech.com/resource-library/brochures/simplify-processes-and-fuel-growth-bankingeasy-core-banking-solution	");
		url.add("	https://www.bankexamstoday.com/2015/08/cbs-core-banking-solution.html	");
		url.add("	https://www.tagitmobile.com/digital-banking/	");
		url.add("	https://www.healthit.gov/topic/safety/clinical-decision-support#:~:text=Clinical%20decision%20support%20(CDS)%20provides,making%20in%20the%20clinical%20workflow.	");
		url.add("	https://bcmj.org/articles/clinical-decision-support-systems	");
		url.add("	https://library.ahima.org/doc?oid=300027	");
		url.add("	https://healthitanalytics.com/features/understanding-the-basics-of-clinical-decision-support-systems	");
		url.add("	https://www.nature.com/articles/s41746-020-0221-y	");
		url.add("	https://www.cdc.gov/dhdsp/pubs/guides/best-practices/clinical-decision-support.htm	");
		url.add("	https://www.ncbi.nlm.nih.gov/books/NBK543516/	");
		url.add("	https://www.fda.gov/regulatory-information/search-fda-guidance-documents/clinical-decision-support-software	");
		url.add("	https://searchhealthit.techtarget.com/definition/clinical-decision-support-system-CDSS	");
		url.add("	https://www.hindawi.com/journals/jhe/2018/6945498/	");
		url.add("	https://healthmanagement.org/s/clinical-decision-support-systems-future-or-present-in-icu	");
		url.add("	https://webmedy.com/blog/what-do-you-understand-by-clinical-decision-support-system/	");
		url.add("	https://www.intechopen.com/books/telemedicine-techniques-and-applications/clinical-decision-support-systems	");
		url.add("	https://www.cms.gov/Regulations-and-Guidance/Legislation/EHRIncentivePrograms/Downloads/ClinicalDecisionSupport_Tipsheet-.pdf	");
		url.add("	https://www.healthcareitnews.com/blog/top-5-benefits-clinical-decision-support-ed	");
		url.add("	https://bmcmedresmethodol.biomedcentral.com/articles/10.1186/s12874-018-0587-6	");
		url.add("	https://www.ebsco.com/health-care/clinical-decision-support	");
		url.add("	https://www.philips.co.in/healthcare/solutions/patient-monitoring/clinical-decision-support	");
		url.add("	https://www.frontiersin.org/articles/10.3389/fimmu.2020.02116/full	");
		url.add("	http://www.ijmedrev.com/article_68717.html	");
		url.add("	https://ieeexplore.ieee.org/document/7349687	");
		url.add("	https://www.raps.org/news-and-articles/news-articles/2020/1/clinical-decision-support-software-stakeholders-s	");
		url.add("	https://www.chilmarkresearch.com/guidance-on-clinical-decision-support-definitions-and-transparency/	");
		url.add("	https://hitinfrastructure.com/news/policies-needed-for-ai-enabled-clinical-decision-support-systems	");
		url.add("	https://www.hl7.org/Special/committees/dss/index.cfm	");
		url.add("	https://erj.ersjournals.com/content/53/4/1900339	");
		url.add("	https://www.jmir.org/2019/3/e11732/	");
		url.add("	https://pubs.rsc.org/en/content/articlelanding/2020/lc/d0lc00373e	");
		url.add("	https://healthcaretransformers.com/digital-health/clinical-decision-support-predictive-analytics/	");
		url.add("	https://www.itnonline.com/article/intro-clinical-decision-support-radiology	");
		url.add("	https://www.dicardiology.com/article/advances-clinical-decision-support-software	");
		url.add("	https://www.analyticsinsight.net/clinical-decision-support-system-can-be-the-biggest-challenges-in-ai-and-healthcare/	");
		url.add("	https://www.nursingcenter.com/lnc/ce_articleprint?an=00024665-201307000-00003	");
		url.add("	https://towardsdatascience.com/ai-in-clinical-decision-support-roadblocks-opportunities-fddb3311fe99	");
		url.add("	https://www.pcpcc.org/resource/clinical-decision-support-medical-home?language=en	");
		url.add("	https://ehr.meditech.com/ehr-solutions/clinical-decision-support	");
		url.add("	https://www.corelaboratory.abbott/int/en/offerings/brands/aliniq/aliniq-cds	");
		url.add("	https://www.acr.org/Clinical-Resources/Clinical-Decision-Support	");
		url.add("	https://www.msdmanuals.com/en-in/professional/special-subjects/clinical-decision-making/electronic-health-records-ehr-and-clinical-decision-support	");
		url.add("	https://www.ukessays.com/essays/computer-science/types-of-clinical-decision-support-system-computer-science-essay.php	");
		url.add("	https://www.marketresearchfuture.com/reports/clinical-decision-support-systems-market-6038	");
		url.add("	https://www.usa.philips.com/healthcare/solutions/patient-monitoring/clinical-decision-support	");
		url.add("	https://www.eanm.org/publicpress/nuclear-medicine-clinical-decision-support/	");
		url.add("	https://ehrc.iiitb.ac.in/project/clinical-decision-support-solution-cdss	");
		url.add("	https://pubs.asahq.org/anesthesiology/article/128/2/247/17796/Regulatory-Landscape-for-Clinical-Decision-Support	");
		url.add("	https://capitahealthcaredecisions.com/products-and-services/clinical-support/	");
		url.add("	https://jamanetwork.com/collections/5589/clinical-decision-support	");
		url.add("	https://support.drchrono.com/hc/en-us/articles/202495020-Core-6-Clinical-Decision-Support	");
		url.add("	https://www.ajmc.com/view/trends-in-the-use-of-clinical-decision-support-by-health-system-affiliated-ambulatory-clinics-in-the-united-states-20142016	");
		url.add("	https://windsongwny.com/radiology/clinical-decision-support-mechanism-cdsm-information/	");
		url.add("	https://healthdata.gov/dataset/clinical-decision-support-cds-inventory	");
		url.add("	https://www.amia.org/programs/working-groups/clinical-decision-support	");
		url.add("	https://ehrintelligence.com/news/the-deadly-consequences-of-ehr-clinical-decision-support-tools	");
		url.add("	https://www.tranow.com/for-providers/cds/	");
		url.add("	http://eknygos.lsmuni.lt/springer/56/698-736.pdf	");
		url.add("	https://academic.oup.com/jamia/article/27/11/1688/5912186	");
		url.add("	https://bisresearch.com/industry-report/clinical-decision-support-systems-market.html	");
		url.add("	https://www.ahajournals.org/doi/10.1161/JAHA.119.014704	");
		url.add("	https://www.medtechdive.com/news/latest-fda-clinical-decision-support-software-draft-a-step-forward-industr/569927/	");
		url.add("	https://edhub.ama-assn.org/collections/5589/clinical-decision-support	");
		url.add("	https://www.infinx.com/blog/implementing-the-2020-cms-mandate-for-clinical-decision-support/	");
		url.add("	https://www.igi-global.com/dictionary/clinical-decision-support-systems/3984	");
		url.add("	https://www.aap.org/en-us/advocacy-and-policy/aap-health-initiatives/immunizations/Practice-Management/Pages/clinical-decision-support.aspx	");
		url.add("	https://www.fdalawblog.net/2019/10/fda-issues-a-second-draft-guidance-for-clinical-decision-support-software/	");
		url.add("	http://www.pharmabiz.com/ArticleDetails.aspx?aid=107621&sid=1	");
		url.add("	https://www.topmastersinhealthcare.com/job-profiles/clinical-trial-manager/	");
		url.add("	https://www.nccn.org/patients/resources/clinical_trials/phases.aspx	");
		url.add("	https://www.iths.org/ctms/about/what-is-a-clinical-trial-management-system/	");
		url.add("	https://www.clinfo.eu/ctms/	");
		url.add("	https://www.appliedclinicaltrialsonline.com/view/ctms-what-you-should-know	");
		url.add("	https://www.genae.com/services/clinical-trial-management	");
		url.add("	https://credevo.com/articles/2020/03/15/software-and-data-management-tools-in-clinical-trials/	");
		url.add("	https://www.cliniindia.com/clinical-trial-management/	");
		url.add("	https://www.jli.edu.in/course/professional-diploma-in-clinical-trial-management/	");
		url.add("	https://www.jliedu.com/programs/detail/professional-diploma-in-clinical-trial-management	");
		url.add("	http://www.clinicaltrialsmgt.com/	");
		url.add("	https://www.veristat.com/services/clinical-operations/project-management	");
		url.add("	https://www.clinion.com/benefits-of-a-clinical-trial-management-system/	");
		url.add("	https://www.grandviewresearch.com/industry-analysis/clinical-trial-management-system-ctms-market	");
		url.add("	https://www.ct-toolkit.ac.uk/routemap/trial-management-and-monitoring/	");
		url.add("	https://www.medidata.com/en/clinical-trial-services/clinical-operations/ctms	");
		url.add("	https://www.genengnews.com/insights/improving-integrated-clinical-trial-management-systems-through-blockchain/	");
		url.add("	https://totalcro.com/	");
		url.add("	https://parexel-academy.com/en/akademischeprogramme/mba-in-clinical-research-management/	");
		url.add("	https://www.bsi-lifesciences.com/solutions/ctms.html	");
		url.add("	https://www.clintrialworks.com/	");
		url.add("	https://globalhealthtrials.tghn.org/resources/trial-management/	");
		url.add("	https://sourceforge.net/software/clinical-trial-management/india/	");
		url.add("	https://www.gminsights.com/industry-analysis/clinical-trial-management-system-ctms-market	");
		url.add("	https://www.oraclinical.com/our-services/cro-services/clinical/clinical-trial-management/	");
		url.add("	http://www.pcs.udel.edu/clinical-trials/	");
		url.add("	https://www.conted.ox.ac.uk/courses/clinical-trial-management	");
		url.add("	https://www.york.cuny.edu/biology/programs-courses/clinical-trial-management-ms	");
		url.add("	https://shp.rutgers.edu/health-informatics/master-of-science-clinical-trial-sciences/	");
		url.add("	https://www.jobhero.com/job-description/examples/medical/clinical-trial-manager	");
		url.add("	https://grahamschool.uchicago.edu/academic-programs/professional-development/clinical-trials	");
		url.add("	https://www.crosnt.com/ctms/	");
		url.add("	https://wcs.uwo.ca/public/category/courseCategoryCertificateProfile.do?method=load&certificateId=26577&selectedProgramAreaId=&selectedProgramStreamId=	");
		url.add("	https://postdegree.uwo.ca/Programs/clinicalmanagement/index.html	");
		url.add("	https://www.gihsonline.com/clinical-trials-management/	");
		url.add("	https://www.unige.ch/formcont/cours/clinical-trials	");
		url.add("	https://pharmacy.temple.edu/academics/certificate-programs-qara/clinic-trial-management	");
		url.add("	https://datapharmaustralia.com/services/clinical-trial-management/	");
		url.add("	https://healthsciences.nova.edu/healthsciences/mhs/clinicaltrialmanagerGC.html	");
		url.add("	https://www.whitehalltraining.com/clinical-trial-management---face-to-face	");
		url.add("	https://www.outsourcing-pharma.com/Article/2019/12/11/Risk-based-approaches-in-clinical-trial-management	");
		url.add("	https://asuonline.asu.edu/online-degree-programs/graduate/master-science-clinical-research-management/	");
		url.add("	https://research.med.uky.edu/research-clinical-trial-management-system	");
		url.add("	https://rimuhc.ca/clinical-research/clinical-trial-management	");
		url.add("	https://www.merieuxnutrisciences.com/eu/biofortis-innovation-services/clinical-research/clinical-trial-management	");
		url.add("	https://www.medgadget.com/2020/10/clinical-trial-management-system-market-share-trends-and-research-development-report-to-2025.html	");
		url.add("	https://www.online.drexel.edu/online-degrees/biomedical-degrees/ms-crom/index.aspx	");
		url.add("	https://conductscience.com/fundamentals-of-lab-management/#:~:text=The%20goal%20of%20lab%20management,and%20training%20new%20lab%20personnel.	");
		url.add("	https://www.purdue.edu/science/careers/what_can_i_do_with_a_major/laboratory_manager.html	");
		url.add("	https://www.asbmb.org/asbmb-today/careers/092313/how-to-become-a-good-lab-manager	");
		url.add("	https://www.ptglab.com/news/blog/how-to-be-a-great-lab-manager-6-tips/	");
		url.add("	https://www.mynewlab.com/blog/8-management-skills-you-need-to-be-a-laboratory-manager/	");
		url.add("	https://www.labmanager.com/business-management/lab-management-fundamentals-2641	");
		url.add("	https://www.sciencemag.org/careers/2012/05/lab-management	");
		url.add("	https://www.aacc.org/education/online-certificate-programs/laboratory-management	");
		url.add("	https://web.iima.ac.in/exed/programme-details.php?id=NzI5	");
		url.add("	https://www.acs.org/content/acs/en/careers/college-to-career/chemistry-careers/lab-management.html	");
		url.add("	https://www.labfolder.com/a-guide-to-better-lab-management/	");
		url.add("	http://gynecology.sbmu.ac.ir/uploads/4_5827853291584749656.pdf	");
		url.add("	https://www.who.int/ihr/publications/lqms_en.pdf	");
		url.add("	https://www.asmscience.org/content/book/10.1128/9781555817695	");
		url.add("	https://www.srlworld.com/partner-with-us/hospital-lab-management	");
		url.add("	https://mocdoc.in/blog/what-is-laboratory-information-management-system	");
		url.add("	https://www.mlo-online.com/management/article/21130719/best-practices-in-lab-management	");
		url.add("	https://healthcare-in-europe.com/en/news/managing-the-medical-laboratory.html	");
		url.add("	https://www.rushu.rush.edu/college-health-sciences/academic-programs/master-science-clinical-laboratory-management	");
		url.add("	https://www.clma.org/	");
		url.add("	https://www.genofab.com/laboratory-information-management-systems	");
		url.add("	https://hiring.monster.com/employer-resources/job-description-templates/laboratory-manager-job-description/	");
		url.add("	https://caredatainfo.com/lims-laboratory-management/	");
		url.add("	https://www.medlabmag.com/	");
		url.add("	https://www.cartercenter.org/resources/pdfs/health/ephti/library/lecture_notes/med_lab_tech_students/LN_Hlth_Lab_Mgmnt_final.pdf	");
		url.add("	https://www.science.gov/topicpages/l/laboratory+management+system	");
		url.add("	https://www.bachelorsportal.com/studies/56421/laboratory-management.html	");
		url.add("	http://www.ifcc.org/ifcc-education-division/emd-committees/c-clm/10-clinical-laboratory-management-toolbox/	");
		url.add("	https://rjlg.com/laboratory-services/laboratory-management/	");
		url.add("	https://www.sgsgroup.in/en-gb/training-services/industry-based-training/life-sciences-training/laboratory-management	");
		url.add("	https://www.darkintelligencegroup.com/tdr-insider/top-laboratory-management-requires-top-business-skills/	");
		url.add("	https://hss-institute.org/laboratory-management-diploma/	");
		url.add("	https://hhbc.in/lab-management/	");
		url.add("	https://joinpop.org/programs-courses/lab-management-online/	");
		url.add("	https://www.umgc.edu/academic-programs/bachelors-degrees/laboratory-management-major.cfm	");
		url.add("	https://www.global-engage.com/event/pharmaceutical-facility-and-laboratory-management-congress/	");
		url.add("	https://www.foodsafetymagazine.com/categories/testing-and-analysis-category/laboratory-management/	");
		url.add("	https://www.plm.automation.siemens.com/global/en/industries/medical-devices-pharmaceuticals/pharmaceuticals/laboratory-information-management.html	");
		url.add("	https://www.pathologyoutlines.com/managementlab.html	");
		url.add("	https://blog.livehealth.in/3-major-challenges-in-laboratory-management-ways-to-solve-them-493e3b0d1245	");
		url.add("	https://iopscience.iop.org/article/10.1088/1742-6596/1361/1/012068/pdf	");
		url.add("	https://www.avl.com/lab-management	");
		url.add("	https://www.amp.org/education/molecular-laboratory-management-reporting-a-short-course-for-laboratory-professionals/	");
		url.add("	https://www.apollodiagnostics.in/for-business-partners/hospital-lab-management	");
		url.add("	http://www.labcompare.com/General-Laboratory-Equipment/6063-Lab-Management-Software/	");
		url.add("	https://www.bsigroup.com/en-IN/iso-17025-laboratory-quality-system/iso-17025-laboratory-management-system-implementation-training-course/	");
		url.add("	https://www.nist.gov/document-62	");
		url.add("	https://www.telstar.com/engineering-projects/software-digitalization/laboratory-management/	");
		url.add("	https://www.labvinelearning.com/Images/Courses/21697f28-242f-48b6-8ee8-67c0446d1c7b.pdf	");
		url.add("	https://www.epa.ie/pubs/advice/water/aq/laboratory_management.pdf	");
		url.add("	https://www.medicalexpo.com/medical-manufacturer/laboratory-management-system-15587.html	");
		url.add("	https://www.labconscious.com/videos	");
		url.add("	http://asq.org/lab-management/index.html	");
		url.add("	https://labofchoice.com/	");
		url.add("	https://www.acgil.com/products/laboratory-information-system.htm	");
		url.add("	https://www.clinicallabmanager.com/author/clinical-laboratory-management-association	");
		url.add("	https://thepathologist.com/inside-the-lab/laboratory-management	");
		url.add("	https://www.aoac.org/inside-laboratory-management/	");
		url.add("	http://www.hunter.cuny.edu/mls/graduate/ms-in-biomedical-laboratory-management	");
		url.add("	https://www.labware.cloud/blog/best-practices-effective-laboratory-management	");
		url.add("	http://labmed.oxfordjournals.org/content/labmed/27/1/20.full.pdf	");
		url.add("	https://www.xybion.com/digital-lab-management-system/research-and-scientific-laboratory-management/	");
		url.add("	https://www.questia.com/library/journal/1G1-503273243/four-effective-ways-to-improve-laboratory-management	");
		url.add("	https://www.law.cornell.edu/cfr/text/40/262.214	");
		url.add("	https://hmsdesk.com/laboratory-systems.php	");
		url.add("	https://www.the-scientist.com/tag/lab-management	");
		url.add("	https://www.battelle.org/government-offerings/health/public-health/on-site-lab-management	");
		url.add("	https://www.convercent.com/lp/compliance-managementmeaning	");
		url.add("	https://www.verywellmind.com/what-is-compliance-2795888	");
		url.add("	https://corporater.com/en/business-solutions/compliance-management/	");
		url.add("	https://www.metricstream.com/products/compliance-management.htm	");
		url.add("	https://redflaggroup.com/compliance-management-solution/	");
		url.add("	https://www.pichainlabs.com/compliance-management-software/	");
		url.add("	https://www.lasergrc.com/compliance-management-system-helping-companies.asp	");
		url.add("	https://www.happiestminds.com/solutions/compliancevigil/	");
		url.add("	https://lexcomply.com/enterprise-compliance-management	");
		url.add("	https://www.provana.com/compliance-management-system	");
		url.add("	https://infopulse-scm.com/blog/best-compliance-management-solutions/	");
		url.add("	https://www.tyasuite.com/blog/post/7-ways-to-make-life-easy-with-compliance-management-software	");
		url.add("	https://insights.truyo.com/choosing-a-compliance-management-software-how-to-pick-the-right-one	");
		url.add("	https://avedos.com/en/compliance-management-system/	");
		url.add("	http://cdn.ihs.com/www/pdf/0219/Brochure_Compliance_Management_Upstream_English.pdf	");
		url.add("	https://www.manageengine.com/it-compliance-suite.html	");
		url.add("	http://www.mkgcglobal.com/services-legal-&-regulatory-compliance-management-system.shtml	");
		url.add("	http://www.grcstack.com/compliance-management-software-solution.php	");
		url.add("	https://www.ndm.net/rsa/rsa-compliance-management-solution	");
		url.add("	https://www.softexpert.com/solucao/governance-risk-compliance-management-grc/	");
		url.add("	https://www.compliancecohort.com/what-is-compliance-management-system	");
		url.add("	https://www.readinow.com/compliance-management	");
		url.add("	https://akarion.com/en/compliance-cloud/	");
		url.add("	http://legasisservices.com/legatrix-compliance-management-software-solutions.html	");
		url.add("	https://www.wegalvanize.com/compliance-management/	");
		url.add("	https://www.esecuritysolutions.com/compliance/regulatory-compliance/	");
		url.add("	https://repositrak.com/press-release/alltech-adopts-repositrak-food-safety-compliance-management-solution/	");
		url.add("	https://mycompliance.me/management-software	");
		url.add("	https://www.exceptionaire.com/case-study-equipment-compliance-management-system/	");
		url.add("	https://www.otesat-maritel.com/article/8/compliance-management-system	");
		url.add("	https://www.grantthornton.in/globalassets/1.-member-firms/india/assets/pdfs/grant-thornton-compliance-management-solution.pdf	");
		url.add("	https://www.v-comply.com/	");
		url.add("	http://www.techperspect.com/portfolio/compliance-management-system/	");
		url.add("	https://crozdesk.com/accounting-finance/compliance-software/lawrbit-global-compliance-management-solution	");
		url.add("	https://www.compfie.com/	");
		url.add("	https://complianceexperts.com/2015/05/15/14-essentials-for-your-compliance-management-system/	");
		url.add("	http://www.eambrace.com/eambrace/software-compliance-management.php	");
		url.add("	https://www.glassdoor.co.in/Reviews/Risk-Management-Solutions-Reviews-E137869.htm	");
		url.add("	https://www.bloomberg.com/profile/company/1652384Z:US	");
		url.add("	https://www.preventionweb.net/organizations/1822	");
		url.add("	https://www.dnb.co.in/risk-management-solutions	");
		url.add("	https://in.indeed.com/cmp/Risk-Management-Solutions-(rms)	");
		url.add("	https://www.sas.com/en_us/solutions/risk-management.html	");
		url.add("	http://jobbuzz.timesjobs.com/company/risk-management-solutions-inc?compids=1514	");
		url.add("	https://risk.lexisnexis.com/products/risk-management-solutions	");
		url.add("	https://www.aviva.co.uk/risksolutions/	");
		url.add("	http://www.bmarisk.com/	");
		url.add("	https://www.theprmspromise.com/	");
		url.add("	https://nbfm.ca/en/products-and-services/risk-management-solutions-and-derivatives/	");
		url.add("	https://www.globenewswire.com/news-release/2020/01/16/1971258/0/en/Wolters-Kluwer-Signs-Agreement-to-Acquire-CGE-Risk-Management-Solutions.html	");
		url.add("	https://training.refinitiv.com/portal/product.php?pid=63	");
		url.add("	https://www.gbm.hsbc.com/solutions/global-trade-receivables-finance/trade-risk-management	");
		url.add("	https://www.managementsolutions.com/en/services/risk-management-control	");
		url.add("	https://www.cleverism.com/company/risk-management-solutions-rms/	");
		url.add("	https://www.wolterskluwerindia.co.in/company/newsroom/news/2020/1/wolters-kluwer-signs-agreement-to-acquire-cge-risk-management-solutions.html	");
		url.add("	https://www.egencia.co.in/en/traveller-risk-management	");
		url.add("	https://risk-management.insuranceciooutlook.com/vendors/risk-management-solution-companies.html	");
		url.add("	https://www.shine.com/jobs/hiring-for-modeler/risk-management-solutions-inc/10843806/	");
		url.add("	https://www.gep.com/strategy/supply-chain-consulting/supply-chain-risk-management	");
		url.add("	https://www.dnb.com.hk/Risk-Management/page.htm	");
		url.add("	https://www.rmsoa.com/	");
		url.add("	https://www.glassdoor.co.uk/Overview/Working-at-Risk-Management-Solutions-EI_IE137869.11,36.htm	");
		url.add("	https://spendmatters.com/almanac/global-risk-management-solutions/	");
		url.add("	https://www.roongtasecurities.com/insurance-and-risk-management-solutions.php	");
		url.add("	https://www.brmsinc.com/	");
		url.add("	https://risk.nexis.com/riskmanagement	");
		url.add("	https://www.online.citibank.co.in/portal/newgen/corporate/global_commercial_banking/CRB/treasury.htm	");
		url.add("	https://intellijobs.ai/job/Risk-Management-Solutions-RMS-Modeler-Q0X8BvJuJftleGjoFdcZ	");
		url.add("	https://www.indeed.co.in/Rms-Risk-Management-Solutions-jobs-in-Noida,-Uttar-Pradesh	");
		url.add("	https://www.lseg.com/markets-products-and-services/post-trade-services/ccp-services/ccg-english-version/services/risk-management-solutions	");
		url.add("	https://www.globalrms.com/	");
		url.add("	https://www.kantox.com/en/	");
		url.add("	https://www.paramountassure.com/solutions/security-and-risk-management	");
		url.add("	https://wrmsglobal.com/	");
		url.add("	https://www.safexpay.com/risk-management.html	");
		url.add("	https://searchinform.com/infosec-blog/2019/06/16/what-is-risk-management-solutions-strategies-services/	");
		url.add("	http://www.cibccm.com/cibc-eportal-web/portal/wm?pageId=risk-management-solutions&language=en_CA	");
		url.add("	https://www.internationalairportreview.com/company_profile/34883/cge-risk-management-solutions-2/	");
		url.add("	https://corpbiz.io/learning/fraud-risk-management-solutions-are-the-need-of-the-hour/	");
		url.add("	https://www.aapc.com/practice-management/practice-management.aspx	");
		url.add("	https://www.gebauer.com/blog/medical-practice-management-system	");
		url.add("	https://www.quatrishealthco.com/practice-management-resources-what-is-practice-management-software/	");
		url.add("	https://www.ama-assn.org/practice-management	");
		url.add("	https://www.psychiatry.org/psychiatrists/practice/practice-management	");
		url.add("	https://www.revelemd.com/blog/top-5-practice-management-challenges-and-solutions	");
		url.add("	https://success.ada.org/en/practice-management	");
		url.add("	https://www.definitions.net/definition/practice+management	");
		url.add("	https://technologyadvice.com/blog/healthcare/best-medical-practice-management-software/	");
		url.add("	http://www.binaryspectrum.com/industries/healthcare/focusareas/practice_management_software.html	");
		url.add("	https://www.pmimd.com/	");
		url.add("	https://www.aad.org/practicecenter	");
		url.add("	https://www.maximizedrevenue.com/	");
		url.add("	https://ehr.wrshealth.com/practice_new/	");
		url.add("	https://www.aao.org/practice-management	");
		url.add("	https://www.firstpracticemanagement.co.uk/	");
		url.add("	https://www.acponline.org/practice-resources	");
		url.add("	https://www.clio.com/	");
		url.add("	http://www.healthcarebusinesstech.com/healthcare-management/practice-management/	");
		url.add("	https://www.infectiousdiseaseadvisor.com/home/topics/practice-management/	");
		url.add("	https://www.magonlinelibrary.com/journal/prma	");
		url.add("	https://www.psychiatryadvisor.com/home/practice-management/	");
		url.add("	https://www.facs.org/advocacy/practmanagement	");
		url.add("	https://www.wealthmanagement.com/practice-management	");
		url.add("	https://www.cap.org/member-resources/practice-management	");
		url.add("	https://www.dentistryiq.com/practice-management	");
		url.add("	https://www.greenwayhealth.com/solutions/medical-practice-management-software	");
		url.add("	https://cmpbenefits.icai.org/practice-management-software/	");
		url.add("	https://www.ehnac.org/practice-management-system-accreditation-program/	");
		url.add("	https://www.pershing.com/what-we-provide/marketing-and-practice-management/	");
		url.add("	https://www.asahq.org/practicemanagement	");
		url.add("	https://gi.org/practice-management/	");
		url.add("	https://www.thecardiologyadvisor.com/home/topics/practice-management/	");
		url.add("	https://aaos.org/quality/practice-management/	");
		url.add("	https://journals.sagepub.com/home/hpm	");
		url.add("	https://www.ifac.org/knowledge-gateway/preparing-future-ready-professionals/publications/guide-practice-management-small-and-medium-sized-practices	");
		url.add("	https://insights.daffodilsw.com/blog/why-build-your-own-practice-management-system-pms	");
		url.add("	https://www.aoa.org/news/practice-management	");
		url.add("	https://www.velvetech.com/blog/efficient-practice-management-system/	");
		url.add("	https://www.continuouscare.io/practice-management-software/	");
		url.add("	https://www.ncarb.org/gain-axp-experience/experience-requirements/practice-management	");
		url.add("	https://www.ehrinpractice.com/ehr-features-practice-management.html	");
		url.add("	https://www.getcanopy.com/practice-management	");
		url.add("	https://medium.com/@medicalservice/what-is-practice-management-in-health-care-cea8dfd5114c	");
		url.add("	https://www.aaaai.org/practice-resources/running-your-practice/practice-management-resources/practice-management-workshop	");
		url.add("	https://www.asra.com/pain-resource/category/27/practice-management	");
		url.add("	https://pubmed.ncbi.nlm.nih.gov/20622592/	");
		url.add("	https://aasm.org/event/practice-management/	");
		url.add("	https://www.foundationeducation.edu.au/articles/2018/02/what-does-practice-manager-do	");
		url.add("	https://www.hbma.org/content/about/medical-billing-revenue-cycle-management	");
		url.add("	https://healthinformatics.uic.edu/blog/what-is-healthcare-revenue-cycle-management/	");
		url.add("	https://bhmpc.com/2013/11/10-steps-boosting-profitability-revenue-cycle/	");
		url.add("	https://revcycleintelligence.com/features/what-is-healthcare-revenue-cycle-management	");
		url.add("	https://www.nthrive.com/blog/revenue-cycle-management-in-hospitals-redefined-from-patient-to-payment	");
		url.add("	https://www.ecareindia.com/revenue-cycle-management-company.html	");
		url.add("	https://www.accesshealthcare.com/services/revenue-cycle	");
		url.add("	https://www.beckershospitalreview.com/lists/210-revenue-cycle-companies-in-healthcare-to-know-2019.html	");
		url.add("	https://qwayhealth.com/blog/10-important-steps-of-medical-billing-in-revenue-cycle-management/	");
		url.add("	https://www.veetechnologies.com/industries/healthcare-provider/revenue-cycle-management.htm	");
		url.add("	https://www.outsource2india.com/Healthcare/revenue-cycle-management.asp	");
		url.add("	https://sybridmd.com/blogs/value-based-programs/measuring-the-effectiveness-of-revenue-cycle-management-in-healthcare/	");
		url.add("	https://blackbookmarketresearch.com/finance-revenue-cycle-management	");
		url.add("	https://www.coronishealth.com/blog/how-an-effective-revenue-cycle-management-benefits-your-practice/	");
		url.add("	https://www.fortunebusinessinsights.com/industry-reports/revenue-cycle-management-market-100275	");
		url.add("	https://www.4dglobalinc.com/billing-and-coding-companies/significance-of-revenue-cycle-management-in-health-care-delivery/	");
		url.add("	https://medcitynews.com/2020/11/how-to-improve-revenue-cycle-management-5-tips/	");
		url.add("	https://health.economictimes.indiatimes.com/health-files/healthcare-revenue-cycle-management-rcm-outsourcing-is-on-an-upswing/813	");
		url.add("	https://www.legacyconsultingservices.com/revenue-cycle-management-2-2/	");
		url.add("	https://ascent-group.com/services.php	");
		url.add("	https://www.outsourcinginsight.com/outsourced-revenue-cycle-management/	");
		url.add("	https://www.decorm.com/five-hospital-revenue-cycle-management-challenges-healthcare-providers-face/	");
		url.add("	https://www.rannsolve.com/what-is-revenue-cycle-management/	");
		url.add("	https://ntchealthcare.com/resources/revenue-cycle-management-process-challenges-systems	");
		url.add("	https://blog.pmmconline.com/blog/revenue-cycle-management-explained	");
		url.add("	https://www.firstsource.com/hospital-revenue-cycle-management/	");
		url.add("	https://www.invensis.net/blog/benefits-rcm-outsourcing/	");
		url.add("	https://swhealth.com/providers/revenue-cycle-management-info/	");
		url.add("	https://www.assurancemd.com/quality-revenue-cycle-management-requires-more-than-a-billing-company/	");
		url.add("	https://www.kgisl.com/bss/Revenue_Management.html	");
		url.add("	https://www.hcinnovationgroup.com/finance-revenue-cycle/revenue-cycle-management/article/21096978/revenue-cycle-management-in-the-valuebased-era-its-a-whole-new-ball-game	");
		url.add("	https://jindalx.com/revenue-cycle-management-rcm-services-us/	");
		url.add("	https://www.3genconsulting.com/hospital-revenue-cycle-management/	");
		url.add("	https://www.p3care.com/blog/10-steps-of-medical-billing-services-for-effective-revenue-cycle-management/	");
		url.add("	https://www.veritystream.com/who-we-serve/revenue-cycle-management-companies	");
		url.add("	https://store.frost.com/industries/revenue-cycle-management.html	");
		url.add("	https://resourcecenter.infinit-o.com/blog/how-to-optimize-revenue-cycle-management/	");
		url.add("	https://medcorinc.com/revenue-cycle-management-the-revenue-cycle/	");
		url.add("	https://thescript.zocdoc.com/what-is-healthcare-revenue-cycle-management-2/	");
		url.add("	https://www.trizettoprovider.com/solutions/revenue-cycle-management	");
		url.add("	https://www.healthcarefinancenews.com/directory/revenue-cycle-management	");
		url.add("	https://www.healthdatamanagement.com/list/20-leading-revenue-cycle-management-vendors	");
		url.add("	http://novigoservices.com/services/revenue-cycle-management-solutions/	");
		url.add("	https://www.usfhealthonline.com/resources/key-concepts/ehr-vs-emr/	");
		url.add("	https://nnlm.gov/mcr/training/technology-program/electronic-health-records-ehrs	");
		url.add("	https://digital.ahrq.gov/key-topics/electronic-medical-record-systems	");
		url.add("	https://bmchealthservres.biomedcentral.com/articles/10.1186/s12913-019-4763-0	");
		url.add("	https://main.mohfw.gov.in/sites/default/files/17739294021483341357.pdf	");
		url.add("	http://nhp.gov.in/ehr_standards_mtl_mtl	");
		url.add("	https://www.cancer.gov/publications/dictionaries/cancer-terms/def/electronic-health-record	");
		url.add("	https://csd.columbia.edu/sites/default/files/content/docs/ICT%20India/Papers/ICT_India_Working_Paper_25.pdf	");
		url.add("	https://vikaspedia.in/health/nrhm/national-health-policies/electronic-health-record-standards-for-india	");
		url.add("	https://www.myhealthrecord.gov.au/	");
		url.add("	https://kidshealth.org/en/parents/ehrs.html	");
		url.add("	https://www.ehealthireland.ie/Strategic-Programmes/Electronic-Health-Record-EHR-/	");
		url.add("	https://innovatemedtec.com/digital-health/ehr--emr	");
		url.add("	https://www.ehealth.gov.hk/en/about_ehrss/electronic_health_record/index.html	");
		url.add("	https://www.ehra.org/	");
		url.add("	https://www.nrces.in/download/files/pdf/nrces_ehr_stand_india.pdf	");
		url.add("	https://www.healthcare-administration-degree.net/faq/what-are-electronic-health-records/	");
		url.add("	https://www.ada.org/en/member-center/member-benefits/practice-resources/dental-informatics/electronic-health-records	");
		url.add("	https://www.infoway-inforoute.ca/en/solutions/digital-health-foundation/electronic-health-records	");
		url.add("	https://www.ihs.gov/ehr/	");
		url.add("	https://s3.amazonaws.com/rdcms-himss/files/production/public/HIMSSorg/Content/files/Code%20180%20MITRE%20Key%20Components%20of%20an%20EHR.pdf	");
		url.add("	https://journalofethics.ama-assn.org/article/electronic-health-records-privacy-confidentiality-and-security/2012-09	");
		url.add("	https://e-estonia.com/solutions/healthcare/e-health-record/	");
		url.add("	https://www.cureus.com/articles/21899-electronic-health-record-implementation-a-review-of-resources-and-tools	");
		url.add("	https://hellohealth.com/solutions/electronic-health-record/	");
		url.add("	https://www.computerworld.com/article/3535083/covid-19-puts-new-demands-on-e-health-record-systems.html	");
		url.add("	https://www.forbesindia.com/article/brand-connect/health-interface-%C3%A2%E2%82%AC-the-future-of-electronic-health-records/60791/1	");
		url.add("	https://ec.europa.eu/digital-single-market/en/exchange-electronic-health-records-across-eu	");
		url.add("	https://www.britannica.com/topic/electronic-health-record	");
		url.add("	https://online.regiscollege.edu/master-health-administration/benefits-of-electronic-health-records/	");
		url.add("	https://www.csp.org.uk/professional-clinical/digital-physiotherapy/electronic-health-records	");
		url.add("	https://www.hhs.gov/sites/default/files/ocr/privacy/hipaa/understanding/consumers/privacy-security-electronic-records.pdf	");
		url.add("	https://www.innovationnewsnetwork.com/electronic-health-records-for-clinical-research/4930/	");
		url.add("	https://www.aan.com/tools-and-resources/practicing-neurologists-administrators/health-information-technology/electronic-health-records/	");
		url.add("	https://www.hsph.harvard.edu/news/magazine/fall08ehrpersonalvshealth/	");
		url.add("	https://blueehr.com/our-services/electronic-health-records/	");
		url.add("	https://www.rcpe.ac.uk/college/journal/electronic-health-records-critical-appraisal-strengths-and-limitations	");
		url.add("	https://www.annualreviews.org/doi/full/10.1146/annurev-publhealth-031914-122747	");
		url.add("	https://www.getcirrus.com/en/ehr	");
		url.add("	https://healthtechmagazine.net/article/2019/12/3-ways-electronic-health-records-will-continue-improve-2020-perfcon	");
		url.add("	https://www.tandfonline.com/doi/full/10.1080/23294515.2020.1755383	");
		url.add("	https://whatis.techtarget.com/definition/electronic-medical-record-EMR	");
		url.add("	https://craveinfotech.com/sap-crave-electronic-medical-record/	");
		url.add("	https://bmcfampract.biomedcentral.com/articles/10.1186/s12875-020-1099-0	");
		url.add("	https://tmc.gov.in/index.php/en/e-medical-records-webemr	");
		url.add("	https://journals.plos.org/plosone/article?id=10.1371/journal.pone.0234108	");
		url.add("	http://www.nextgenesolutions.com/product/electronic-medical-record	");
		url.add("	https://www.imedpub.com/scholarly/electronic-medical-records-journals-articles-ppts-list.php	");
		url.add("	https://www.healthaffairs.org/doi/full/10.1377/hlthaff.24.5.1103	");
		url.add("	https://www.webopedia.com/definitions/emr-electronic-medical-record/	");
		url.add("	https://www.emrfinder.com/all-emr-software/	");
		url.add("	https://www.techopedia.com/definition/25008/electronic-medical-record-emr	");
		url.add("	https://www.i-scoop.eu/digital-transformation/healthcare-digital-health/electronic-medical-records/	");
		url.add("	https://technorely.com/emr-using-blockchain/	");
		url.add("	https://www.spandidos-publications.com/10.3892/etm.2016.3233	");
		url.add("	https://www.physio-pedia.com/Electronic_Medical_Records	");
		url.add("	http://clinicalestablishments.gov.in/WriteReadData/107.pdf	");
		url.add("	https://www.signifyresearch.net/reports/electronic-medical-records-world-2018/	");
		url.add("	https://www.thehindu.com/sci-tech/health/the-hindu-explains-how-will-a-centralised-electronic-medical-records-tool-help-to-monitor-trends-about-covid-19/article32420209.ece	");
		url.add("	https://www.skillscommons.org/handle/taaccct/2254	");
		url.add("	https://www.aafp.org/fpm/2001/0500/p33.html	");
		url.add("	https://www.ijo.in/article.asp?issn=0301-4738;year=2020;volume=68;issue=3;spage=417;epage=418;aulast=Honavar	");
		url.add("	https://www.raster.in/emr.php	");
		url.add("	https://www.damicopettinicchi.com/scholarly-articles/the-electronic-medical-record-audit-logs-and-revision-history	");
		url.add("	https://www.nationaljewish.org/patients-visitors/patient-info/emr	");
		url.add("	https://drdollah.com/clinical-information-system/creation-and-use-of-the-electronic-medical-record/	");
		url.add("	https://ooc.usc.edu/healthcare-compliance/emr-standards/	");
		url.add("	https://doctorinprogress.com/2019/09/15/the-problem-with-electronic-medical-records/?locale=en	");
		url.add("	https://www.pennfoster.edu/programs-and-degrees/medical-basics/electronic-medical-records-certificate	");
		url.add("	https://www.scientificamerican.com/article/can-ai-fix-electronic-medical-records/	");
		url.add("	https://www.livemint.com/Politics/CucBmKaoWLZuSf1Y9VaafM/Adoption-of-emedical-records-facing-infra-hurdles-Report.html	");
		url.add("	https://www.uscjournal.com/articles/electronic-medical-record	");
		url.add("	https://store.sap.com/product/display-0000008075_live_v1/cHealthcare-%20Electronic%20Medical%20Record	");
		url.add("	https://www.scielo.br/scielo.php?pid=S1413-81232020000401293&script=sci_arttext	");
		url.add("	https://openmrs.org/	");
		url.add("	https://help.practo.com/category/practo-ray/emr/	");
		url.add("	https://www.takingcharge.csh.umn.edu/create-personal-health-record#:~:text=A%20personal%20health%20record%20(PHR,compile%2C%20update%2C%20and%20keep.	");
		url.add("	https://www.urmc.rochester.edu/encyclopedia/content.aspx?contenttypeid=1&contentid=2716	");
		url.add("	http://www.americanehr.com/blog/2012/09/patient-portals-and-personal-health-records/	");
		url.add("	https://www.apolloclinic.com/phr/	");
		url.add("	https://medlineplus.gov/personalhealthrecords.html	");
		url.add("	https://fabrydiseasenews.com/2020/01/30/tips-for-maintaining-a-personal-health-record-when-you-have-fabry-disease/	");
		url.add("	https://bmcmedinformdecismak.biomedcentral.com/articles/10.1186/s12911-019-0969-7	");
		url.add("	https://www.health.harvard.edu/newsletter_article/Links-to-resources-for-creating-a-personal-health-record	");
		url.add("	https://www.nhs.uk/nhs-services/online-services/nhs-app/nhs-app-help-and-support/personal-health-records/	");
		url.add("	https://patientengagementhit.com/features/how-do-patient-portals-and-personal-health-records-differ	");
		url.add("	https://www.informationweek.com/healthcare/patient-tools/9-popular-personal-health-record-tools/d/d-id/1103871?	");
		url.add("	https://www.re-health.eea.iom.int/e-phr	");
		url.add("	https://www.emeraldgrouppublishing.com/archived/products/journals/call_for_papers.htm%3Fid%3D4178	");
		url.add("	https://digital.nhs.uk/services/personal-health-records-adoption-service/personal-health-records-adoption-toolkit	");
		url.add("	https://www.cdac.in/index.aspx?id=hi_mhs_product_myhealthrecords	");
		url.add("	https://www.healthspek.com/	");
		url.add("	https://pn.ispirt.in/phr-the-quest-for-use-cases/	");
		url.add("	https://www.newindianexpress.com/thesundaystandard/2019/oct/27/personal-health-records-now-a-tap-away-with-centres-my-health-record-mobile-app-2053453.html	");
		url.add("	https://lupinepublishers.com/biomedical-sciences-journal/fulltext/effects-of-personal-health-record-on-patient-healthcare-outcomes.ID.000134.php	");
		url.add("	https://nephcure.org/livingwithkidneydisease/managing-your-care/kidney-health-tracking-tools/keeping-a-personal-health-record/	");
		url.add("	https://www.realclearhealth.com/articles/2020/08/29/owning_personal_health_records_is_the_key_to_medical_innovation_111090.html	");
		url.add("	http://ojin.nursingworld.org/MainMenuCategories/ANAMarketplace/ANAPeriodicals/OJIN/Columns/Informatics/Electronic-Personal-Health-Records.html	");
		url.add("	https://www.softclinicsoftware.com/personal-health-records-app/	");
		url.add("	https://medical-dictionary.thefreedictionary.com/personal+health+record	");
		url.add("	https://issues.org/etzioni/	");
		url.add("	https://www.apollocradle.com/personal-health-record/	");
		url.add("	https://www.rcpjournals.org/content/futurehosp/6/1/52	");
		url.add("	https://www.apollospectra.com/personal-health-record-phr/	");
		url.add("	https://www.unomaha.edu/human-resources/_documents/personal-health-reports.pdf	");
		url.add("	https://www.amerihealth.com/htdocs/help/phr_faq.html	");
		url.add("	https://wiki.ihe.net/index.php/Exchange_of_Personal_Health_Record_Content_Profile	");
		url.add("	https://betterhealthwhileaging.net/how-to-use-personal-health-record-in-aging/	");
		url.add("	https://www.zapbuild.com/solutions/healthcare/phr	");
		url.add("	https://oag.ca.gov/privacy/facts/medical-privacy/health-record	");
		url.add("	https://bmjopen.bmj.com/content/9/9/e028628	");
		url.add("	https://community.pega.com/sites/default/files/cma-combined-glossary/content/healthcare_glossary/p/phr.htm	");
		url.add("	https://www.computer.org/csdl/magazine/co/2012/11/mco2012110027/13rRUyoPSSx	");
		url.add("	https://www.lifecard.com/about-lifecard-personal-health-record/	");
		url.add("	https://core.ac.uk/download/pdf/26757366.pdf	");
		url.add("	https://www.healthadvantage-hmo.com/providers/resource-center/health-information-network/personal-health-record-(phr)	");
		url.add("	https://arxiv.org/pdf/1609.03615	");
		url.add("	https://pediatrics.aappublications.org/content/124/1/403	");
		url.add("	https://blog.massmutual.com/post/a-personal-health-record-can-help-you-stay-healthy-lower-costs	");
		url.add("	https://www.rcplondon.ac.uk/file/5653/download	");
		url.add("	https://portal.ct.gov/DSS/ITS/DSS-HealthIT/Business-Intelligence-and-DSS-HealthIT/Personal-Health-Record	");
		url.add("	https://www.fepblue.org/personal-health-record	");
		url.add("	https://sustainabledevelopment.un.org/partnership/?p=30034	");
		url.add("	https://www.arkansasbluecross.com/providers/resource-center/health-information-network/personal-health-record-(phr)	");
		url.add("	https://softwareconnect.com/erp/what-is-erp/	");
		url.add("	https://terillium.com/benefits-of-erp/	");
		url.add("	https://www.scc-co.com/blog/bid/27920/What-Does-a-Best-in-Class-ERP-Solution-Include	");
		url.add("	https://insights.sap.com/what-is-erp/	");
		url.add("	https://www.cio.com/article/2439502/what-is-erp-key-features-of-top-enterprise-resource-planning-systems.html	");
		url.add("	https://dynamics.microsoft.com/en-in/erp/what-is-erp/	");
		url.add("	https://www.jobinandjismi.com/blog/what-is-erp-enterprise-resource-planning/	");
		url.add("	https://planful.com/blog/enterprise-performance-management-vs-enterprise-resource-planning/	");
		url.add("	https://www.inc.com/encyclopedia/enterprise-resource-planning-erp.html	");
		url.add("	https://www.ifs.com/corp/solutions/enterprise-resource-planning/	");
		url.add("	https://www.shopify.in/encyclopedia/enterprise-resource-planning-erp	");
		url.add("	https://www.optiproerp.com/what-is-manufacturing-erp/	");
		url.add("	https://www.pelotongroup.com/services/enterprise-resource-planning/	");
		url.add("	https://www.genisys-group.com/enterprise-resource-planning-guide/	");
		url.add("	https://www.nevprobusinesssolutions.com/blog/what-is-erp-systems-and-how-it-works/	");
		url.add("	https://the365people.com/enterprise-resource-planning	");
		url.add("	https://www.syspro.com/product/what-is-erp/	");
		url.add("	https://www.aviationbusinessnews.com/mro/enterprise-resource-planning/	");
		url.add("	https://crgroup.com/enterprise-resource-planning/	");
		url.add("	https://www.godlan.com/syteline-erp-manufacturing-software/what-is-erp-enterprise-resource-planning-/	");
		url.add("	https://www.softwareadvisoryservice.com/en/blog/enterprise-resource-planning-an-overview/	");
		url.add("	https://www.sagesoftware.co.in/erp/	");
		url.add("	https://www.magstarinc.com/retail-technology-blog/what-is-erp	");
		url.add("	https://www.mrpeasy.com/enterprise-resource-planning/	");
		url.add("	https://www.batchmaster.co.in/what-is-erp.aspx	");
		url.add("	https://www.flexsin.com/products-solutions/enterprise-resource-planning.php	");
		url.add("	https://www.javatpoint.com/erp-full-form	");
		url.add("	http://www.itmanagerdaily.com/erp/	");
		url.add("	https://www.saponlinetutorials.com/what-is-erp-systems-enterprise-resource-planning/	");
		url.add("	https://www.pmi.org/learning/library/methodologies-erp-systems-pmbok-8166	");
		url.add("	https://www.workwisellc.com/erp-software/what-is-erp/	");
		url.add("	http://techwave.net/services/enterprise-resource-planning/	");
		url.add("	https://www.intellectsoft.net/blog/what-is-erp-and-how-enterprise-resource-planning-works/	");

		for (String urls : url) {

			String fullUrl = getFullUrl(urls);

			if(!fullUrl.contains(".org")&&!fullUrl.contains(".edu")&&!fullUrl.contains(".gov")
					&&!fullUrl.contains(".ac")&&!fullUrl.contains(".edu"))
			{
				
				if(isCompanyUrl(fullUrl))
				{
					System.out.println(fullUrl);
				}
			}



		}

	}

	public static String getFullUrl(String urls) {
		String urlPrefix=null;
		String urlLink=urls.toString().trim();
		int index=urls.toString().trim().replace("https://www.", "").replace("http://www.", "").replace("https://", "").replace("http://", "").indexOf("/");
		String domain=urls.toString().trim().replace("https://www.", "").replace("http://www.", "").replace("https://", "").replace("http://", "").substring(0,index );

		if(urlLink.contains("www"))
		{
			urlPrefix=urlLink.substring(0, urlLink.indexOf(".")+1);						
		}
		else{
			urlPrefix=urlLink.substring(0, urlLink.indexOf("/")+2);				
		}

		String fullUrl=urlPrefix+domain.replace("www3.", "").replace("www2.", "");
		return fullUrl;
	}

	public static boolean isCompanyUrl(String url) {

		boolean valid = false;

		Document doc = null;
		try {
			SSLExceptionSolution.enableSSLSocket();
			doc = Jsoup.connect(url).userAgent("Mozilla").ignoreHttpErrors(true).get();

			Elements elements = doc.select("a");
			if (elements != null && elements.size() > 0) {
				Set<String> list =new LinkedHashSet<String>();
				for (Element element : elements) {
					try {
						if (element.hasAttr("href")) {

							if(isValidCompanyLink(element.attr("abs:href")))
							{
								//System.out.println(element.text());
								//System.out.println(element.attr("href"));
								//list.add(element.attr("abs:href"));
								
								if(element.text()!=null&&!element.text().isEmpty())
								{
									String text=element.text().toLowerCase();
									
									if (text.startsWith("get a demo") || text.startsWith("demo request")
											|| text.startsWith("start your free trial")
											|| text.startsWith("schedule a demo")
											|| text.startsWith("free trial") || text.startsWith("request demo")
											|| text.startsWith("schedule demo") || text.startsWith("get demo")
											|| text.startsWith("demo") || text.startsWith("get a free trial")
											|| text.startsWith("request a demo")
											|| text.startsWith("product")|| text.startsWith("solution")
											|| text.startsWith("our solution")|| text.startsWith("platform")
											|| text.startsWith("our tech")|| text.startsWith("technology")
											|| text.startsWith("our product")|| text.startsWith("our platform")
											|| text.startsWith("our software")|| text.startsWith("softtware")
											|| text.startsWith("login")|| text.startsWith("log in")
											|| text.startsWith("login page")|| text.startsWith("user login")
											|| text.startsWith("users login")|| text.startsWith("signin")
											|| text.startsWith("sign in")|| text.startsWith("pricing")
											|| text.startsWith("price")|| text.startsWith("get pricing")
											|| text.startsWith("product")|| text.startsWith("our pricing")
											
											) {
									//	System.out.println(text);
										list.add(text);
									}
									
									
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if(list.size()>=1)
				{
					valid = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e1) {
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {	
			e1.printStackTrace();
		}
		return valid;
	}

	public static boolean isValidCompanyLink(String newsUrl) {

		boolean valid = false;

		try {
			ArrayList<String> wordsList = new ArrayList<String>();
			wordsList.add("product");
			wordsList.add("solution");
			wordsList.add("our solution");
			wordsList.add("platform");
			wordsList.add("our tech");
			wordsList.add("technology");
			wordsList.add("our product");
			wordsList.add("our platform");
			wordsList.add("our software");
			wordsList.add("softtware");
			wordsList.add("login");
			wordsList.add("log in");
			wordsList.add("login page");
			wordsList.add("user login");
			wordsList.add("users login");
			wordsList.add("signin");
			wordsList.add("sign in");
			wordsList.add("pricing");
			wordsList.add("price");
			wordsList.add("get pricing");
			wordsList.add("our pricing");
			
			

			for (String word : wordsList) {
				try {
					if (newsUrl.contains(word)) {
						valid = true;
					}
				} catch (Exception excp) {
					excp.printStackTrace();
				}
			}
		} catch (Exception excp) {
			excp.printStackTrace();
		}
		return valid;
	}

}
