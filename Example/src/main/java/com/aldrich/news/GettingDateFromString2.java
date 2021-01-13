package com.aldrich.news;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GettingDateFromString2 {

	public static void main(String[] args) {


		List<String>  url=new ArrayList<String>();
		url.add("	https://mct-trading.com/sarah-hellman-business-women-2020/	");
		url.add("	https://www.equusoft.com/blog/equus-ecosystem-partner-spotlight-k2-global-mobility/	");
		url.add("	https://sproutloud.com/company-news/sproutloud-simplifies-ad-building	");
		url.add("	https://www.etacticsinc.com/press-release/etactics-inc-and-seamless-llc-partner-to-enhance-patient-payment	");
		url.add("	https://www.etacticsinc.com/press-release/2019/4/29/etactics-partners-with-platinum-system-ehr-to-simplify-chiropractic-claims	");
		url.add("	https://www.etacticsinc.com/press-release/2018/3/19/etactics-and-infogps-networks-partner-up-to-automate-security-risk-analysis-1	");
		url.add("	https://www.etacticsinc.com/press-release/2018/3/20/michael-teutsch-president-of-etactics-inc-honored-by-buckingham-doolittle-burroughs-llp	");
		url.add("	https://www.cobalt.pe/blog/preparing-for-2021/	");
		url.add("	https://www.prnewswire.com/news-releases/ruby-ribbon-strengthens-board-of-directors-with-addition-of-business-powerhouse-connie-tang-301193676.html	");
		url.add("	https://www.prnewswire.com/news-releases/visiquate-adds-two-senior-healthcare-analytics-executives-to-leadership-team-301196981.html	");
		url.add("	https://www.collaborativedrug.com/cdd-curve-therapeutics-digitalize-drug-discovery-platform/	");
		url.add("	https://www.reisystems.com/rei-systems-will-deliver-govgrants-tool-for-the-state-of-washingtons-school-funding/	");
		url.add("	https://www.prnewswire.com/news-releases/pathology-lab-and-health-information-exchange-partner-with-ispecimen-to-bring-covid-19-specimens-to-researchers-301195289.html	");
		url.add("	https://voziq.com/customer-retention/most-popular-customer-intelligence-blog-posts-of-2020/	");
		url.add("	https://www.prnewswire.com/news-releases/ataccama-plans-major-growth-push-in-2021-names-martin-zahumensky-chief-growth-officer-301195518.html	");
		url.add("	https://www.ringlead.com/blog/g2-winter-2021-grid-report/	");
		url.add("	https://www.xpertdoc.com/en/resources/newsroom/press-release/experlogix-llc-acquires-xpertdoc-technologies-inc/	");
		url.add("	https://www.prnewswire.com/news-releases/classlink-wins-iste-2020-best-of-show-award-301194323.html	");
		url.add("	https://www.prnewswire.com/news-releases/vigilanz-launches-new-software-for-hospitals-to-rapidly-deploy-and-manage-covid-19-mass-vaccination-events-for-healthcare-workers-301193739.html	");
		url.add("	https://www.igrafx.com/news/g2-crowd-positions-igrafx-as-a-leader-for-business-process-management/	");
		url.add("	https://www.prnewswire.com/news-releases/syxsense-offers-a-year-of-free-it-and-patch-management-software-to-vulnerable-hospitals-battling-pandemic-301194573.html	");
		url.add("	https://www.businesswire.com/news/home/20201216005297/en/ConsumerMedical-Reports-Strong-Growth-Opening-of-New-Market-Segments-in-2020	");
		url.add("	https://www.businesswire.com/news/home/20201216005297/en/ConsumerMedical-Reports-Strong-Growth-Opening-of-New-Market-Segments-in-2020	");
		url.add("	https://resources.copperleaf.com/press-release/copperleaf-wins-the-2020-tech-culture-of-the-year-award	");
		url.add("	https://resources.copperleaf.com/press-release/copperleaf-expands-leadership-team-to-support-global-expansion-and-drive-employee-experience	");
		url.add("	https://resources.copperleaf.com/press-release/transalta-selects-copperleaf-c55-for-asset-investment-planning-and-management	");
		url.add("	https://resources.copperleaf.com/press-release/network-rail-owner-of-europe-s-fastest-growing-railway-chooses-copperleaf-c55	");
		url.add("	https://resources.copperleaf.com/press-release/visue-selects-copperleaf-c55-for-asset-investment-planning-and-management	");
		url.add("	https://resources.copperleaf.com/press-release/copperleaf-appoints-miranda-alldritt-as-president-of-the-americas	");
		url.add("	https://resources.copperleaf.com/press-release/copperleaf-ranks-among-the-fastest-growing-companies-in-north-america-on-deloitte-s-2018-technology-fast-500	");
		url.add("	https://resources.copperleaf.com/press-release/viesgo-selects-copperleaf-c55-to-optimize-investment-planning	");
		url.add("	https://resources.copperleaf.com/press-release/copperleaf-globe-and-mail-canada-top-growing-companies-for-second-consecutive-year	");
		url.add("	https://resources.copperleaf.com/press-release/elia-group-selects-copperleaf-c55-for-portfolio-management	");
		url.add("	https://resources.copperleaf.com/press-release/copperleaf-launches-rapid-scenario-planning-solution-to-help-utilities-with-post-pandemic-agility	");
		url.add("	https://resources.copperleaf.com/press-release/northern-ireland-electricity-networks-selects-copperleaf-c55-for-asset-investment-planning-management	");
		url.add("	https://resources.copperleaf.com/press-release/copperleaf-achieves-soc-2-certification	");
		url.add("	https://www.prnewswire.com/news-releases/sigmoid-named-to-deloittes-technology-fast-500-list-of-fastest-growing-companies-in-north-america-301176654.html	");
		url.add("	https://unicornhro.com/press-releases/unicorn-hro-announces-news-of-latest-partnership-with-benadvance/	");
		url.add("	https://unicornhro.com/press-releases/unicorn-hro-announces-strategic-alliance-partnership-with-visual-computer-solutions-to-expand-payroll-and-workforce-management-offerings/	");
		url.add("	https://www.prnewswire.com/news-releases/nobl-team-members-earn-top-certification-as-patient-experience-professionals-301192530.html?tc=eml_cleartime	");
		url.add("	http://www.smithtravelresearch.com/press-release/str-hnn-launch-hotel-data-conference-global-edition	");
		url.add("	http://www.prnewswire.com/news-releases/cincinnati-childrens-hospital-medical-center-completes-recruitment-for-pediatric-migraine-study-using-curelator-headache-300276280.html	");
		url.add("	https://economictimes.indiatimes.com/tech/funding/leadsquared-lands-32-million-in-funding-led-by-gaja-capital/articleshow/79756818.cms	");
		url.add("	https://www.girikon.com/company/press-release/girikon-makes-it-again-to-the-inc-5000-list-for-the-second-consecutive-year/	");
		url.add("	https://www.prnewswire.com/news-releases/marketing-360-named-in-capterras-top-20-most-popular-lead-generation-softwares-301193663.html	");
		url.add("	https://www.prnewswire.com/news-releases/honk-and-parkhub-partner-to-create-safety-first-parking-solution-launching-at-university-of-arizona-this-season-301107676.html?tc=eml_cleartime	");
		url.add("	https://www.prnewswire.com/news-releases/parkhub-welcomes-cliff-wickstrum-as-vp-of-sales-operations-300941868.html	");
		url.add("	http://www.prnewswire.com/news-releases/parkhub-integrates-with-ticketscom-as-first-and-only-certified-parking-platform-300434152.html?tc=eml_cleartime	");
		url.add("	https://www.prnewswire.com/news-releases/itopia-launches-support-for-windows-10-vdi-on-google-cloud-with-all-new-management-platform-301195101.html	");
		url.add("	https://www.prnewswire.com/news-releases/itopia-empowers-artnet-to-streamline-mission-critical-vdi-on-google-cloud-301170072.html	");
		url.add("	https://www.prnewswire.com/news-releases/itopia-announces-expansion-in-india-with-country-manager-harshal-pendse-former-partnership-manager-at-google-cloud-301099195.html	");
		url.add("	https://www.demandjump.com/press-release/demandjump-named-to-inc-5000	");
		url.add("	https://www.demandjump.com/press-release/demandjump-appoints-spring-rouhana-as-chief-financial-officer	");
		url.add("	https://www.demandjump.com/press-release/demandjump-named-10-best-places-to-work-in-indiana	");
		url.add("	https://www.demandjump.com/press-release/demandjump-announces-joe-kuntz-as-cro	");
		url.add("	https://www.demandjump.com/press-release/demandjump-secures-6m-series-a-to-fuel-customer-acquisition-platform	");
		url.add("	https://www.demandjump.com/press-release/demandjump-is-a-finalist-for-the-2016-red-herring-100-global-award	");
		url.add("	https://www.demandjump.com/press-release/demandjump-taps-top-retail-executive-for-cro-position	");
		url.add("	https://www.demandjump.com/press-release/demandjump-closes-additional-1.8m-in-series-seed-and-announces-commercial-launch-of-award-winning-artificial-intelligence-marketing-aim-platform	");
		url.add("	https://www.demandjump.com/press-release/demandjump-announces-750k-capital-raise-and-early-access-to-its-predictive-analytics-marketing-platform-1	");
		url.add("	https://www.orioncom.com/press-releases/orion-named-2020-company-of-the-year-by-cio-review-magazine	");
		url.add("	https://www.orioncom.com/press-releases/orion-communications-announces-software-rebrand	");
		url.add("	https://www.livedata.com/press-releases/livedata-launches-periop-planner-real-time-solution-to-plan-visualize-and-analyze-surgical-scheduling	");
		url.add("	https://www.livedata.com/press-releases/veterans-healthcare-facility-in-ann-arbor-deploys-livedata-periop-manager-throughout-or-suite	");
		url.add("	https://www.livedata.com/press-releases/st.-joseph-mercy-ann-arbor-expands-use-of-livedata-technology-to-new-outpatient-surgery-center-and-hybrid-operating-room	");
		url.add("	https://www.livedata.com/press-releases/va-st.-louis-health-care-system-to-install-livedata-periop-manager-with-dss-integration-to-vista-electronic-health-record-system	");
		url.add("	https://www.livedata.com/press-releases/orlando-va-medical-center-to-install-livedata-periop-manager-in-all-10-operating-rooms-at-new-state-of-the-art-facility	");
		url.add("	https://www.livedata.com/press-releases/miami-va-healthcare-system-extends-its-use-of-livedata-patient-safety-solution-throughout-the-entire-perioperative-suite	");
		url.add("	https://www.livedata.com/press-releases/massachusetts-general-hospital-expands-use-of-livedata-or-dashboard-with-active-time-out	");
		url.add("	https://www.livedata.com/press-releases/hospital-of-the-university-of-pennsylvania-deploys-livedata-or-dashboard-in-cardiovascular-operating-rooms	");
		url.add("	https://www.gr8people.com/press-releases/2019/01/15/new-headquarters-for-gr8-people	");
		url.add("	https://www.gr8people.com/press-releases/2018/11/07/new-brand-and-website-launch	");
		url.add("	https://www.prnewswire.com/news-releases/lumenvox-launches-active-voice-authentication-on-genesys-appfoundry-301006265.html?tc=eml_cleartime	");
		url.add("	https://www.voxware.com/press-releases/voxware-named-2017-fl100	");
		url.add("	https://www.onramp.bio/blog/canopy-partnership	");
		url.add("	https://www.onramp.bio/blog/nanostring-partnership	");
		url.add("	https://www.spoonity.com/press-releases-archive/spoonity-vivonet-launch-new-embedded-pos-mode/	");
		url.add("	https://www.spoonity.com/press-releases-archive/spoonity-pos-king-loyalty-mobile-payments-integration/	");
		url.add("	https://rezku.com/press-releases/rezku-and-magtek	");
		url.add("	https://www.wishpond.com/press-releases/66130/wishpond-to-acquire-invigo-media-corp-a-profitable-and-growing-marketing-technology-and-services-company/	");
		url.add("	https://blog.gloo.us/press-releases/gloo-powers-state-of-the-church	");
		url.add("	https://blog.gloo.us/press-releases/barna-state-of-the-church	");
		url.add("	https://www.prnewswire.com/news-releases/runsafe-security-appoints-veteran-security-experts-to-technical-advisory-board-301061122.html?tc=eml_cleartime	");
		url.add("	https://www.businesswire.com/news/home/20201217005185/en/JetStream-Software-Announces-Availability-of-JetStream-DR-for-Microsoft-Azure-VMware-Solution-with-Azure-Blob-Storage	");
		url.add("	https://www.prnewswire.com/news-releases/goodfinch-announces-the-final-closing-of-fund-iii-with-commitments-totaling-145-million-301198178.html	");
		url.add("	https://www.trustscience.com/news/press-releases/trust-science-flexes-new-bench-strength-names-former-equifax-executive-as-chief-data-and-analytics-officer	");
		url.add("	https://www.trustscience.com/news/press-releases/trust-science-ai-company-of-the-year	");
		url.add("	https://www.prnewswire.com/news-releases/california-based-pacific-coast-title-deploys-safewire-to-protect-against-real-estate-wire-fraud-301194882.html	");
		url.add("	https://www.prnewswire.com/news-releases/proximie-announces-senior-executive-appointments-as-global-demand-for-its-ar-health-tech-platform-accelerates-301194778.html	");
		url.add("	https://www.claimlogiq.com/press-releases/claimlogiq-announces-vp-operations-and-director-hr-compliance?hslang=en	");
		url.add("	https://www.onemodel.co/press-releases/one-model-announces-launch-of-one-ai	");
		url.add("	https://www.onemodel.co/press-releases/one-model-announces-analytics-for-smartrecruiters-customers	");
		url.add("	https://www.onemodel.co/press-releases/one-model-secures-3.7-million-in-funding	");
		url.add("	https://www.businesswire.com/news/home/20201216005029/en/ChaosSearch-Announces-40-Million-Series-B-Funding-Round	");
		url.add("	https://www.prnewswire.com/news-releases/syndigo-announces-growth-equity-partnership-with-summit-partners-301193608.html	");
		url.add("	https://blog.lendingpad.com/press-releases/complianceease-announces-integration-with-lendingpad	");
		url.add("	https://blog.lendingpad.com/press-releases/corelogic-integrates-credit-and-flood-services-with-lendingpad	");
		url.add("	https://blog.lendingpad.com/press-releases/lendingpad-is-selected-to-be-on-the-2019-housingwire-tech100-list	");
		url.add("	https://blog.lendingpad.com/press-releases/unify-crm-and-lendingpad-announce-their-technology-integration-and-strategic-partnership	");
		url.add("	https://blog.lendingpad.com/press-releases/mgic-mortgage-insurance-is-now-available-through-lendingpad-los	");
		url.add("	https://preservica.com/resources/press-releases/preservica-announces-new-free-forever-digital-preservation	");
		url.add("	https://preservica.com/resources/press-releases/preservica-congratulates-2020-emmett-leahy-award-winner	");
		url.add("	https://preservica.com/resources/press-releases/preservica-accelerates-product-innovation-with-3-8m-funding-from-mobeus	");
		url.add("	https://preservica.com/resources/press-releases/national-archives-and-preservica-partner-to-secure-australias-digital-memory	");
		url.add("	https://www.businesswire.com/news/home/20201216005659/en/Preservica-Announces-New-Free-forever-Digital-Preservation-Solution	");
		url.add("	https://www.businesswire.com/news/home/20201217005323/en/Elevate-Security-Continues-Strong-Customer-Growth-and-Recruits-Notable-Security-Sales-Executive-to-Scale-Rapid-Expansion	");
		url.add("	https://www.prnewswire.com/news-releases/tim-tk-keanini-distinguished-engineer-product-line-cto-for-analytics-at-cisco-joins-802-secures-advisory-board-to-help-strengthen-and-execute-cyber-physical-iot-network-security-vision-300807100.html	");
		url.add("	https://blog.pelican.ai/news/press-releases/tim-blackmore-global-sales-head	");
		url.add("	https://blog.pelican.ai/news/press-releases/pelican-launches-ai-powered-sanctions-self-learning-module-to-dramatically-reduce-false-positive-rates	");
		url.add("	https://blog.pelican.ai/news/press-releases/pelican-group-launches-pelican-pay	");
		url.add("	https://blog.pelican.ai/news/press-releases/what-will-website-be-like-in-100-years	");
		url.add("	https://blog.pelican.ai/news/press-releases/pelican-launches-open-banking-api-solution-to-support-psd2-compliance	");
		url.add("	https://blog.pelican.ai/news/press-releases/pelican-appoints-tristan-blampied-as-senior-product-manager-and-launches-first-pelican-points-of-view-ppv-discussion-paper-at-ebaday	");
		url.add("	https://www.fics.com/in-the-news/press-releases/commercial-mortgage-servicing-software-boosts-automation/	");
		url.add("	https://www.cube.global/about-cube/news/2020/12/15/cube-appoints-new-cfo-and-cso-to-further-advance-its-industry-leading-regulatory-intelligence-technology/	");
		url.add("	https://cyberscout.com/en/press-releases/cyberscout-named-2020-cyber-risk-service-provider-of-the-year-by-insurance-insider	");
		url.add("	https://www.verenia.com/press-releases/verenia-3d-now-available	");
		url.add("	https://www.verenia.com/press-releases/verenia-announces-new-collaboration-with-liquidpixels	");
		url.add("	https://www.verenia.com/press-releases/verenias-products-among-the-highest-rated-in-the-industry	");
		url.add("	https://www.prnewswire.com/news-releases/harps-food-stores-selects-birdzis-customer-engagement-ecosystem-301007559.html	");
		url.add("	https://www.businesswire.com/news/home/20201217005703/en/DataLink-Acquires-Orizon360%C2%B0-Expands-Value-based-Clinical-Data-Integration-Advanced-Analytics-and-Financial-Informatics-Capabilities	");
		url.add("	https://www.prnewswire.com/news-releases/grin-closes-10m-investment-led-by-eventures-and-joined-by-a-syndicate-of-the-some-of-the-worlds-most-successful-e-commerce-founders-301195435.html	");
		url.add("	https://www.businesswire.com/news/home/20201217005234/en/Hiretual-Launches-Transformative-AI-Sourcing-Enhancements-to-Simplify-Security-Clearance-Recruiting	");
		url.add("	https://www.censinet.com/press-release/klas-and-censinet-partnership-press-release/	");
		url.add("	https://www.clinithink.com/press-releases/clinithink-secures-growth-equity	");
		url.add("	https://www.clinithink.com/press-releases/clinithink-receives-rare-champion-of-hope-award-for-their-notable-efforts-in-rare-disease	");
		url.add("	https://www.marconet.com/press-releases/marco-purchases-advanced-office-systems-in-new-jersey	");
		url.add("	https://www.marconet.com/press-releases/marco-to-launch-lets-tech-podcast	");
		url.add("	https://www.marconet.com/press-releases/marco-named-to-crns-2020-solution-provider-500-list	");
		url.add("	https://www.marconet.com/press-releases/dale-evens-receives-enx-difference-makers-award	");
		url.add("	https://www.marconet.com/press-releases/marco-honored-as-high-achieving-it-solution-provider-in-vendor-certifications	");
		url.add("	https://www.marconet.com/press-releases/marco-launches-certified-partner-program-for-its-managed-it-services	");
		url.add("	https://www.marconet.com/press-releases/marco-recognized-for-excellence-in-managed-it-services-2020	");
		url.add("	https://www.marconet.com/press-releases/marco-purchases-image-systems-for-business-in-new-jersey	");
		url.add("	https://www.prnewswire.com/news-releases/eon-celebrates-215th-go-live-with-milestone-launch-at-kalispell-regional-healthcare-301175916.html	");
		url.add("	https://www.prnewswire.com/news-releases/eon-receives-soc-2-type-ii-attestation-300931214.html	");
		url.add("	https://www.prnewswire.com/news-releases/eon-receives-soc-2-type-i-attestation-300806719.html	");
		url.add("	https://www.businesswire.com/news/home/20201216005135/en/Lodasoft-Names-Mark-Ramirez-New-Head-of-Product	");
		url.add("	https://www.prnewswire.com/news-releases/data-governance-and-security-leader-privacera-secures-13-5-million-in-series-a-funding-301094014.html	");
		url.add("	https://www.prnewswire.com/news-releases/privacera-announces-latest-version-of-the-privacera-platform-for-secure-data-sharing-in-databricks-301078419.html	");
		url.add("	http://links.datagumbo.com/c7f	");
		url.add("	https://accessphysicians.com/press-release/access-physicians-reports-strong-growth-in-2020/	");
		url.add("	https://www.wraltechwire.com/2020/12/23/wilmingtons-performance-culture-lands-2-1m-investment-from-jurassic-capital/	");
		url.add("	https://buff.ly/34xZHok	");
		url.add("	https://www.prnewswire.com/news-releases/blockapps-and-schweitzer-laboratories-partner-to-build-campaign-finance-compliance-system-4us-restoring-trust-and-confidence-in-the-political-financing-process-301193722.html	");
		url.add("	https://www.motadata.com/press-release/motadata-deloitte-technology-fast500-apac-winner/	");
		url.add("	https://www.prnewswire.com/news-releases/sovereign-intelligence-launches-new-geodata-analysis-as-a-service-to-provide-accurate-location-intelligence-on-a-global-scale-301193105.html	");
		url.add("	https://www.prnewswire.com/news-releases/dr-calum-macrae-to-become-senior-advisor-to-biosymetrics-300791661.html	");
		url.add("	https://www.prnewswire.com/news-releases/snapap-secures-new-equity-investment-financing-led-by-israel-based-angel-group-301194714.html	");
		url.add("	https://www.feedstock.com/press-releases/feedstock-announces-the-appointment-of-james-tromans-as-a-board-advisor/	");
		url.add("	https://www.mirrorweb.com/press-releases/mirrorweb-receives-2m-investment-to-fuel-expansion	");
		url.add("	https://www.mirrorweb.com/press-releases/mirrorweb-named-in-manchesters-top-10-startups-in-2020	");
		url.add("	https://www.mirrorweb.com/press-releases/mirrorweb-secures-1m-in-first-round-of-funding	");
		url.add("	https://www.prnewswire.com/news-releases/valisure-and-cabinet-announce-a-partnership-for-certification-of-over-the-counter-products-301125756.html	");
		url.add("	https://www.prnewswire.com/news-releases/valisure-launches-first-online-analytical-pharmacy-that-chemically-validates-medications-300720750.html	");
		url.add("	https://www.prnewswire.com/news-releases/valisure-is-launching-the-first-digital-pharmacy-to-chemically-validate-medications-300643313.html	");
		url.add("	https://www.prnewswire.com/news-releases/cybint-lcc-international-university-is-the-first-university-bootcamp-partnership-for-cyber-in-europe-301193551.html	");
		url.add("	https://www.axonivy.com/news/partnership-with-blue-prism	");
		url.add("	http://www.moneymover.com/about/press-releases/2018/aug/20/money-mover-and-alternative-investment-management-/	");
		url.add("	http://www.moneymover.com/about/press-releases/2018/may/3/money-mover-save-uk-smes-thousands-new-kashflow-pa/	");
		url.add("	http://www.moneymover.com/about/press-releases/2017/may/23/money-mover-delivers-for-smes/	");
		url.add("	http://www.moneymover.com/about/press-releases/2017/may/10/money-mover-raises-further-500k-investment-funding/	");
		url.add("	http://www.moneymover.com/about/press-releases/2016/jun/7/money-mover-launches-partner-and-affiliate-program/	");
		url.add("	http://www.moneymover.com/about/press-releases/2016/apr/13/money-movers-amanda-nunn-named-cambridge-wireless/	");
		url.add("	https://www.uktech.news/news/cargoone-to-ship-temperature-sensitive-covid-19-vaccines-globally-snaps-31m-series-b-funding-20201218	");


		Document document=null;
		String date=null;
		for (String string : url) {

			String urls=string.trim();
			document=getURLResponse(urls);
			date="";
			date=getDateFromString(document.text());
			System.out.println(date);
			//System.out.println(convertAnyTypeDateToSingleFormat(getDateFromString(document.text())));


		}		
	}

	public static Date convertAnyTypeDateToSingleFormat(String dateInString) 
	{
		String dateFormat=null;
		Date date =null;


		String regex1="\\d{4,4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
		String regex2="(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/\\d{4,4}";
		String regex3="(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])\\/\\d{4,4}";
		String regex4="(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])\\-\\d{4,4}";
		String regex5="(0?[1-9]|[12][0-9]|3[01])\\-(0?[1-9]|1[012])\\-\\d{4,4}";
		String regex6="\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex7="(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}";
		String regex8="(0?[1-9]|[12][0-9]|3[01])\\-(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\-\\d{4,4}";
		String regex9="(0?[1-9]|[12][0-9]|3[01])\\,\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}";
		String regex10="(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{4,4}";
		String regex11="(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}";
		String regex12="(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}";
		String regex13="(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}";
		String regex14="[A-Za-z]{3,9}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{1,2}\\s\\d{4,4}";
		String regex15="(0?[1-9]|[12][0-9]|3[01])\\s(0?[1-9]|1[012])\\s\\d{4,4}";
		String regex16="\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex17="(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\.\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}";


		dateInString=dateInString.toLowerCase().replace("t.", "").replace("th", "").replace("nd", "").replace("rd", "");

		if(dateInString!=null&&!dateInString.isEmpty())
		{
			if(dateInString.matches(regex1)){
				dateFormat="yyyy-MM-dd";
			}else if(dateInString.matches(regex2)){
				dateFormat="dd/MM/yyyy";
			}else if(dateInString.matches(regex3)){
				dateFormat="MM/dd/yyyy";
			}else if(dateInString.matches(regex4)){
				dateFormat="MM-dd-yyyy";
			}else if(dateInString.matches(regex5)){
				dateFormat="dd-MM-yyyy";
			}else if(dateInString.matches(regex6)){
				dateFormat="yyyy/MM/dd";
			}else if(dateInString.matches(regex7.toLowerCase())){
				dateFormat="dd MMM yyyy";
			}else if(dateInString.matches(regex8.toLowerCase())){
				dateFormat="dd-MMM-yyyy";
			}else if(dateInString.matches(regex9.toLowerCase())){
				dateFormat="dd, MMM yyyy";
			}else if(dateInString.matches(regex10.toLowerCase())){
				dateFormat="dd MMM, yyyy";
			}else if(dateInString.matches(regex11.toLowerCase())){
				dateFormat="MMM dd yyyy";
			}else if(dateInString.matches(regex12.toLowerCase())){
				dateFormat="MMM, dd yyyy";
			}else if(dateInString.matches(regex13.toLowerCase())){
				dateFormat="MMM dd, yyyy";
			}else if(dateInString.matches(regex14.toLowerCase())){
				dateFormat="E MMM, dd yyyy";
			}else if(dateInString.matches(regex15)){
				dateFormat="dd MM yyyy";
			}else if(dateInString.matches(regex16)){
				dateFormat="yyyy/MM/dd";
			}else if(dateInString.matches(regex17.toLowerCase())){
				dateFormat="MMM. dd, yyyy";
			}else if((dateInString).matches(regex13.toLowerCase())){
				dateFormat="MMM dd, yyyy";
			}


			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			try {
				date = formatter.parse(dateInString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}		
		return date;
	}

	public static String getDateFromString(String docText) {
		docText = docText.toLowerCase().replace("t.", "").replace("rd", "").replace("th", "").replace("nd", "");
		String date = "";
		String regex1 = "\\d{4,4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
		String regex2 = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/\\d{4,4}";
		String regex3 = "(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])\\/\\d{4,4}";
		String regex4 = "(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])\\-\\d{4,4}";
		String regex5 = "(0?[1-9]|[12][0-9]|3[01])\\-(0?[1-9]|1[012])\\-\\d{4,4}";
		String regex6 = "\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex7 = "(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}"
				.toLowerCase();
		String regex8 = "(0?[1-9]|[12][0-9]|3[01])\\-(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\-\\d{4,4}"
				.toLowerCase();
		String regex9 = "(0?[1-9]|[12][0-9]|3[01])\\,\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}"
				.toLowerCase();
		String regex10 = "(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{4,4}"
				.toLowerCase();
		String regex11 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}"
				.toLowerCase();
		String regex12 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}"
				.toLowerCase();
		String regex13 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}"
				.toLowerCase();
		String regex14 = "[A-Za-z]{3,9}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{1,2}\\s\\d{4,4}"
				.toLowerCase();
		String regex15 = "(0?[1-9]|[12][0-9]|3[01])\\s(0?[1-9]|1[012])\\s\\d{4,4}";
		String regex16 = "\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex17 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\.\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}"
				.toLowerCase();

		String dateFormat = "(" + regex1 + ")|(" + regex2 + ")|(" + regex3 + ")|(" + regex4 + ")|(" + regex5 + ")|("
				+ regex6 + ")|(" + regex7 + ")|(" + regex8 + ")|(" + regex9 + ")|(" + regex10 + ")|(" + regex11 + ")|("
				+ regex12 + ")|(" + regex13 + ")|(" + regex14 + ")|(" + regex15 + ")|(" + regex16 + ")|(" + regex17
				+ ")";

		if (docText != null && !docText.isEmpty()) {
			try {
				Pattern compile = Pattern.compile(dateFormat);
				Matcher matcher = compile.matcher(docText);
				if (matcher.find()) {
					date = matcher.group(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	public static  Document getURLResponse(String str) {
		Document doc = null;
		String content=null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault(); // Create an httpclient instance
			HttpGet httpget = new HttpGet(str); // Create a httpget instance
			CloseableHttpResponse response = httpclient.execute(httpget); // Execute the get request
			HttpEntity entity = response.getEntity(); // Get the returned entity
			content = EntityUtils.toString(entity, "utf-8");
			doc = Jsoup.parse(content);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return doc;
	}

}
