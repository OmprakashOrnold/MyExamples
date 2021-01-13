package com.aldrich.jobpostings;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.FormatUrl;
import com.aldrich.patent.SSLExceptionSolution;

public class ExtractCarrerUrls {
	private static String regex="^(https:|http:)(.)*";

	private static String pattern1="(/career/)|(/career)|(/careers/)|(/careers)|(/jobs/)|(/jobs)";

	public static void main(String[] args) {

		List<String> url=new ArrayList<String>();
		url.add("	https://rfidgs.com/	");
		url.add("	https://jackrabbittech.com/	");
		url.add("	https://medicopy.net/	");
		url.add("	https://sproutloud.com/	");
		url.add("	https://online-rewards.com/	");
		url.add("	https://www.net-inspect.com/	");
		url.add("	https://www.ema.us/	");
		url.add("	https://www.salary.com/	");
		url.add("	https://www.shmoop.com/	");
		url.add("	http://www.kannact.com/	");
		url.add("	https://www.indinero.com/	");
		url.add("	https://www.histowiz.com/	");
		url.add("	http://www.accountantsworld.com/	");
		url.add("	https://www.openclinica.com	");
		url.add("	https://www.alacriti.com/	");
		url.add("	https://www.alianza.com/	");
		url.add("	https://www.collaborativedrug.com/	");
		url.add("	https://www.comm100.com/	");
		url.add("	https://compliancy-group.com/	");
		url.add("	https://www.medweb.com/	");
		url.add("	https://clinicalarchitecture.com/	");
		url.add("	http://www.igihealth.com/	");
		url.add("	https://www.obix.com/	");
		url.add("	https://thessigroup.com/	");
		url.add("	https://www.ellkay.com/	");
		url.add("	https://www.eccentex.com/	");
		url.add("	https://www.azaleahealth.com/	");
		url.add("	https://neuroalert.com/	");
		url.add("	http://www.ehiconnect.com/	");
		url.add("	https://www.alanahealthcare.com/	");
		url.add("	https://www.ligolab.com/	");
		url.add("	https://www.revenuewire.com	");
		url.add("	https://www.ebridgeconnections.com	");
		url.add("	https://riskspan.com/	");
		url.add("	https://www.ticksmith.com/	");
		url.add("	http://www.objectiflune.com/	");
		url.add("	https://www.acdlabs.com/	");
		url.add("	https://leanindustries.com/	");
		url.add("	https://www.magnetforensics.com/	");
		url.add("	https://exagoinc.com/	");
		url.add("	https://www.coremobileinc.com/	");
		url.add("	http://www.stonewain.com/	");
		url.add("	http://www.vichara.com/	");
		url.add("	https://www.celayix.com/	");
		url.add("	https://www.globalids.com/	");
		url.add("	https://www.upstreamworks.com/	");
		url.add("	https://www.momentumhealthware.com/	");
		url.add("	https://www.fdm4.com/	");
		url.add("	https://www.mycomplianceoffice.com	");
		url.add("	http://jostle.me/	");
		url.add("	http://www.skyitgroup.com/	");
		url.add("	https://www.zuman.com/	");
		url.add("	https://www.verdantis.com/	");
		url.add("	https://www.edetek.com/	");
		url.add("	http://www.rebarsys.com/	");
		url.add("	https://ptfs.com/	");
		url.add("	https://www.ellumen.com/	");
		url.add("	https://mfino.com/	");
		url.add("	https://lunarline.com/	");
		url.add("	https://activu.com/	");
		url.add("	https://www.logicbroker.com/	");
		url.add("	https://brightsign.biz	");
		url.add("	https://explorance.com/	");
		url.add("	https://ntint.com/	");
		url.add("	http://www.altusdynamics.com	");
		url.add("	https://instapage.com/	");
		url.add("	https://vigilanzcorp.com/	");
		url.add("	https://medicomhealth.com/	");
		url.add("	https://selectdata.com/	");
		url.add("	https://proscan.com/	");
		url.add("	https://sytrue.com/	");
		url.add("	https://www.hint.com/	");
		url.add("	https://sellercloud.com/	");
		url.add("	https://www.liferay.com/	");
		url.add("	https://www.kineticdata.com/	");
		url.add("	https://medikeeper.com/	");
		url.add("	https://www.sciforma.com/	");
		url.add("	https://www.processweaver.com/	");
		url.add("	https://www.savanainc.com/	");
		url.add("	https://www.blazeclan.com/	");
		url.add("	https://www.datafied.com/	");
		url.add("	https://www.panderasystems.com/	");
		url.add("	https://www.penrad.com/	");
		url.add("	https://www.hmchealthworks.com/	");
		url.add("	https://www.labarchives.com/	");
		url.add("	https://www.salucro.com	");
		url.add("	https://hpgroupllc.com/	");
		url.add("	https://www.intellect.com/	");
		url.add("	https://www.4cite.com/	");
		url.add("	https://www.atlassystems.com/	");
		url.add("	https://www.hrgpros.com/	");
		url.add("	https://avasure.com/	");
		url.add("	http://geniemd.com/	");
		url.add("	https://sdata.us/	");
		url.add("	https://www.stratahealth.com/	");
		url.add("	https://www.biosero.com/	");
		url.add("	https://www.kryptowire.com/	");
		url.add("	https://www.prophix.com/	");
		url.add("	https://bluesageusa.com/	");
		url.add("	https://www.smartflowcompliance.com/	");
		url.add("	https://www.archive360.com/	");
		url.add("	https://www.reversevision.com/	");
		url.add("	https://www.finsync.com/	");
		url.add("	https://www.corepartners.com/	");
		url.add("	https://onereach.com/	");
		url.add("	https://servicecentral.com/	");
		url.add("	https://www.decisionresearch.com/	");
		url.add("	https://www.processmap.com/	");
		url.add("	https://www.gtsoftware.com/	");
		url.add("	https://www.ideationts.com/	");
		url.add("	https://www.lablynx.com/	");
		url.add("	https://www.epowerdoc.com/	");
		url.add("	https://www.t1visions.com/	");
		url.add("	https://www.icanotes.com/	");
		url.add("	https://www.salespad.com/	");
		url.add("	https://www.agileassets.com/	");
		url.add("	http://www.preludesoftware.com/	");
		url.add("	https://www.elevenwireless.com/	");
		url.add("	https://www.dmsi.com/	");
		url.add("	https://www.igrafx.com/	");
		url.add("	https://www.sclogic.com/	");
		url.add("	https://www.leanpath.com/	");
		url.add("	https://esha.com/	");
		url.add("	https://www.selerix.com/	");
		url.add("	https://rynoh.com/	");
		url.add("	https://www.sparklinglogic.com/	");
		url.add("	https://www.labkey.com/	");
		url.add("	https://www.reppify.com/	");
		url.add("	https://www.corservsolutions.com/	");
		url.add("	https://www.connectbooster.com	");
		url.add("	https://www.helpfinancial.com/	");
		url.add("	https://www.aliaswire.com/	");
		url.add("	https://www.hawahealth.com/	");
		url.add("	https://www.par8o.com	");
		url.add("	https://www.welvie.com/	");
		url.add("	https://www.arminsight.com/	");
		url.add("	https://www.stria.com	");
		url.add("	https://www.paladion.net/	");
		url.add("	https://www.signalvine.com/	");
		url.add("	http://www.cubexsystem.com/	");
		url.add("	https://www.dassian.com/	");
		url.add("	https://www.enchoice.com/	");
		url.add("	https://www.papersave.com/	");
		url.add("	https://www.employeenavigator.com/	");
		url.add("	https://foresite.com/	");
		url.add("	https://www.assistrx.com/	");
		url.add("	https://www.systemsalliance.com/	");
		url.add("	https://main.omeda.com/	");
		url.add("	https://rayalleninc.com/	");
		url.add("	https://www.btbsecurity.com/	");
		url.add("	https://www.agentisenergy.com/	");
		url.add("	https://www.entando.com/	");
		url.add("	https://www.argosrisk.com/	");
		url.add("	https://unimarket.com/	");
		url.add("	http://www.prcmedical.com	");
		url.add("	https://www.mapyourshow.com/	");
		url.add("	https://www.praedicat.com/	");
		url.add("	https://www.hstpathways.com/	");
		url.add("	https://www.mlogica.com/	");
		url.add("	https://cloudsmartz.com/	");
		url.add("	https://activeops.com/	");
		url.add("	https://www.nabler.com/	");
		url.add("	https://inticousa.com/	");
		url.add("	https://www.ivrtechgroup.com/	");
		url.add("	https://medtrainer.com/	");
		url.add("	https://www.cbtnuggets.com/	");
		url.add("	https://pdxinc.com/	");
		url.add("	https://www.larvol.com/	");
		url.add("	https://triagelogic.com/	");
		url.add("	https://www.1commmedical.com/	");
		url.add("	https://www.medqia.com/	");
		url.add("	https://www.platformq.com/	");
		url.add("	https://www.med-metrix.com/	");
		url.add("	https://imatsolutions.com/	");
		url.add("	https://levatas.com/	");
		url.add("	https://adpearance.com/	");
		url.add("	https://www.copperleaf.com/	");
		url.add("	https://www.himama.com/	");
		url.add("	https://www.flex125.com/	");
		url.add("	https://apollidon.com/	");
		url.add("	https://baseload.com/	");
		url.add("	https://www.boostb2b.com/	");
		url.add("	https://www.buxtonco.com/	");
		url.add("	https://www.dictumhealth.com/	");
		url.add("	https://www.jdaehealth.com/	");
		url.add("	https://www.linkit.com	");
		url.add("	http://www.lionsharemarketing.com/	");
		url.add("	https://www.lumedx.com/	");
		url.add("	https://www.mbms.net/	");
		url.add("	https://oneshield.com/	");
		url.add("	https://www.psgconsults.com/	");
		url.add("	https://www.iprocedures.com/	");
		url.add("	https://www.securitymetrics.com/	");
		url.add("	https://teamworkcommerce.com/	");
		url.add("	https://www.springboardretail.com/	");
		url.add("	https://www.storeforcesolutions.com/	");
		url.add("	https://blueridgeglobal.com/	");
		url.add("	https://www.virtuance.com/	");
		url.add("	https://www.syntasa.com/	");
		url.add("	https://www.persolvent.com/	");
		url.add("	https://www.bdex.com/	");
		url.add("	https://www.pwnhealth.com/	");
		url.add("	https://www.quantiphi.com/	");
		url.add("	https://www.questsoft.com/	");
		url.add("	https://www.rulex.ai/	");
		url.add("	https://shipware.com/	");
		url.add("	https://ambition.com/	");
		url.add("	https://www.gigaspaces.com/	");
		url.add("	https://www.intelligencenode.com/	");
		url.add("	https://chartbeat.com/	");
		url.add("	https://www.codility.com/	");
		url.add("	https://www.tapclicks.com/	");
		url.add("	https://www.ibtapps.com	");
		url.add("	https://gramener.com/	");
		url.add("	https://www.processmaker.com/	");
		url.add("	https://www.emagia.com/	");
		url.add("	https://www.talisclinical.com/	");
		url.add("	https://www.qure4u.com/	");
		url.add("	http://www.corascloud.com/	");
		url.add("	https://www.medispend.com/	");
		url.add("	http://www.reactornet.com/	");
		url.add("	http://crystalcleardm.com/	");
		url.add("	https://arkieva.com/	");
		url.add("	https://wiland.com/	");
		url.add("	http://www.mekorma.com	");
		url.add("	https://innovista-health.com/	");
		url.add("	https://www.beanworks.com/	");
		url.add("	https://www.fischeridentity.com/	");
		url.add("	https://www.assured.enterprises/	");
		url.add("	https://www.internationalbancard.com/	");
		url.add("	https://www.pcmicorp.com/	");
		url.add("	https://www.finpay.net/	");
		url.add("	https://m.epreop.com/	");
		url.add("	https://www.reliantsolutions.com/	");
		url.add("	https://iworq.com/	");
		url.add("	https://avertra.com/	");
		url.add("	https://www.claritasrx.com/	");
		url.add("	https://maws1.healthcareip.com/	");
		url.add("	https://www.invoicesherpa.com/	");
		url.add("	https://emptech.com/	");
		url.add("	https://www.rhythmedix.com/	");
		url.add("	https://www.collect.org/	");
		url.add("	https://1mp.com/	");
		url.add("	https://flywheel.io/	");
		url.add("	https://www.conformit.com/	");
		url.add("	https://www.payworks.ca/	");
		url.add("	https://lumenlearning.com/	");
		url.add("	https://myljm.com/	");
		url.add("	https://ecsfin.com/	");
		url.add("	https://www.wellnessliving.com/	");
		url.add("	https://www.mercatus.com/	");
		url.add("	https://www.dsco.io/	");
		url.add("	https://www.digitaldefense.com/	");
		url.add("	https://www.boltontechnology.com/	");
		url.add("	https://www.gr8people.com/	");
		url.add("	https://dynamichealthsys.com/	");
		url.add("	https://www.voxware.com/	");
		url.add("	https://insurancesystems.com/	");
		url.add("	https://www.illumicare.com/	");
		url.add("	https://fulcrum-gt.com/	");
		url.add("	https://www.ericom.com/	");
		url.add("	https://www.onramp.bio/	");
		url.add("	http://www.hrsoft.com	");
		url.add("	https://elevateservices.com/	");
		url.add("	https://www.fastcase.com/	");
		url.add("	https://www.freshlime.com/	");
		url.add("	https://remedyanalytics.com/	");
		url.add("	https://rpdfin.com/	");
		url.add("	https://www.intellisurvey.com/	");
		url.add("	https://www.ei3.com/	");
		url.add("	https://symend.com/	");
		url.add("	https://textus.com/	");
		url.add("	https://www.bangthetable.com/	");
		url.add("	https://www.hubtran.com/	");
		url.add("	https://feedonomics.com/	");
		url.add("	https://fooji.com/	");
		url.add("	http://intelyt.com/	");
		url.add("	https://www.relativity6.com/	");
		url.add("	https://fireflylearning.com/	");
		url.add("	https://www.figmd.com/	");
		url.add("	https://www.casepoint.com/	");
		url.add("	https://ucmnow.com/	");
		url.add("	https://www.exafluence.com/	");
		url.add("	https://aircarehealth.com/	");
		url.add("	https://paanalytics.com/	");
		url.add("	https://www.mbanq.com/	");
		url.add("	https://haloinvesting.com/	");
		url.add("	https://www.simplifyhealthcare.com/	");
		url.add("	https://lenderprice.com/	");
		url.add("	https://www.netstock.co/	");
		url.add("	https://www.ascentregtech.com/	");
		url.add("	https://brickftp.com/	");
		url.add("	https://yapiapp.com/	");
		url.add("	https://www.benepaytech.com/	");
		url.add("	https://paycertify.com/	");
		url.add("	https://turbinelabs.com/	");
		url.add("	https://www.meddbase.com/	");
		url.add("	https://www.bluejlegal.com/	");
		url.add("	https://www.spinezone.com/	");
		url.add("	https://www.vytalizehealth.com/	");
		url.add("	https://www.ozsystems.com/	");
		url.add("	https://www.totalepay.com/	");
		url.add("	https://smilecdr.com/	");
		url.add("	https://www.docketnavigator.com	");
		url.add("	https://qrails.com/	");
		url.add("	https://landgorilla.com/	");
		url.add("	https://www.verinovum.com/	");
		url.add("	https://www.proplogix.com/	");
		url.add("	https://www.mtrade.com/	");
		url.add("	https://preservica.com/	");
		url.add("	https://www.graymatteranalytics.com/	");
		url.add("	https://verdeintl.com/	");
		url.add("	https://www.pacemate.com/	");
		url.add("	https://www.vitrana.com/	");
		url.add("	https://frameworkmi.org/	");
		url.add("	https://alliantinsight.com/	");
		url.add("	https://imcpt.com/	");
		url.add("	https://www.ap-networks.com/	");
		url.add("	https://www.kiio.com/	");
		url.add("	https://www.pfcfulfills.com/	");
		url.add("	https://pharmacord.com/	");
		url.add("	https://www.knovos.com/	");
		url.add("	https://benelynk.com/	");
		url.add("	https://180healthpartners.com/	");
		url.add("	https://brightorder.com/	");
		url.add("	https://www.strongpoint.io/	");
		url.add("	https://www.everythingbenefits.com/	");
		url.add("	https://www.locushealth.com/	");
		url.add("	https://www.babelstreet.com/	");
		url.add("	https://cyberscout.com	");
		url.add("	https://4chealthsolutions.com/	");
		url.add("	https://www.opusonesolutions.com/	");
		url.add("	https://www.argos-labs.com/	");
		url.add("	https://www.scienaptic.com/	");
		url.add("	https://wambi.org/	");
		url.add("	http://www.keepscorp.com/	");
		url.add("	https://finmkt.io/	");
		url.add("	https://axletrees.com/	");
		url.add("	http://www.livanta.com/	");
		url.add("	https://www.cascadefintech.com/	");
		url.add("	https://easasoftware.com/	");
		url.add("	https://www.infrrd.ai/	");
		url.add("	https://bookkeeper360.com/	");
		url.add("	https://claimvantage.com/	");
		url.add("	https://1huddle.co/	");
		url.add("	https://dmarcian.com/	");
		url.add("	https://www.daxtra.com/	");
		url.add("	https://www.skubana.com/	");
		url.add("	https://govspend.com/	");
		url.add("	https://taxfyle.com/	");
		url.add("	https://www.lexalytics.com/	");
		url.add("	https://www.attuneinsurance.com/	");
		url.add("	https://bushel.ag/	");
		url.add("	https://imagenevp.com/	");
		url.add("	https://tradinghub.com/	");
		url.add("	https://www.givergy.com	");
		url.add("	https://www.gradientai.com/	");
		url.add("	https://jungleworks.com/	");
		url.add("	https://www.kpisoft.com/	");
		url.add("	http://kermitppi.com/	");
		url.add("	https://www.primetrust.com	");
		url.add("	https://www.renttrack.com/	");
		url.add("	https://www.trellahealth.com/	");
		url.add("	https://www.virtualtrader.com/	");
		url.add("	https://www.veryfi.com/	");
		url.add("	https://workiz.com/	");
		url.add("	https://www.quicketsolutions.com	");
		url.add("	https://www.payfare.com/	");
		url.add("	https://www.theclimateservice.com/	");
		url.add("	https://incode.com/	");
		url.add("	https://neocova.com/	");
		url.add("	https://www.nviewhealth.com/	");
		url.add("	https://www.redcapcloud.com/	");
		url.add("	https://www.casebook.net/	");
		url.add("	https://freightwisellc.com/	");
		url.add("	https://vitaldatatech.com/	");
		url.add("	https://www.billfire.com/	");
		url.add("	https://www.interopion.com/	");
		url.add("	https://www.files.com/	");
		url.add("	https://www.worldnetpayments.com/	");
		url.add("	https://www.akirix.com/	");
		url.add("	http://www.facilityhealthinc.com/	");
		url.add("	https://www.kharon.com/	");
		url.add("	https://www.optimize.health/	");
		url.add("	https://munibilling.com/	");
		url.add("	https://spendbridge.com/	");
		url.add("	https://www.bnkbl.com/	");
		url.add("	https://simon.io/	");
		url.add("	https://www.medfarsolutions.com	");
		url.add("	https://www.gornapp.com/	");
		url.add("	https://www.precisetelehealth.com/	");
		url.add("	https://aceage.com/	");
		url.add("	https://www.srarisk.com/	");
		url.add("	https://onlinemeded.org/	");
		url.add("	https://primedash.com/	");
		url.add("	https://www.publicspendforum.net/	");
		url.add("	https://www.spendlabs.com/	");
		url.add("	http://www.enlighta.com/	");
		url.add("	https://www.nexterus.com/	");
		url.add("	https://www.getincentify.com/	");
		url.add("	https://dcubeanalytics.com/	");
		url.add("	https://www.rxdatascience.com/	");
		url.add("	http://www.awpl.co/	");
		url.add("	https://www.deliogroup.com/	");
		url.add("	https://www.symbox.com/	");
		url.add("	https://vectorremote.com/	");
		url.add("	https://www.cardiacrms.com/	");
		url.add("	https://www.accuhealth.tech	");
		url.add("	https://www.b4bpayments.com	");
		url.add("	https://www.myrhythmnow.com/	");
		url.add("	http://loanpro.io/	");
		url.add("	https://www.circuitclinical.com/	");
		url.add("	https://spesana.com/	");
		url.add("	https://www.cancerinsights.com	");
		url.add("	https://upswot.com/	");
		url.add("	https://www.securecdp.com/	");
		url.add("	https://connective.eu/	");
		url.add("	https://www.mynxg.com/	");
		url.add("	http://www.friendlyscore.com/	");
		url.add("	http://www.unifimoney.com	");
		url.add("	http://crassula.io	");
		url.add("	http://www.fintecture.com	");





		String urls=null;	
		for (String string : url) {

			urls=string.trim();

			if(urls.matches(regex))
			{
				String creerLinks=getCreerLinks1(urls);
				if(!creerLinks.isEmpty()&&creerLinks!=null)
				{

					List<String> careerPages=new ArrayList<String>();
					Document document=getURLResponse(creerLinks);
					Elements links = document.select("a[href]");

					links.forEach((e) -> {
						careerPages.add(e.attr("abs:href"));		     
					});

					GetProperJobPostingsUrls(urls, careerPages,creerLinks);
				}
			}
		}
	}

	public static void GetProperJobPostingsUrls(String urls, List<String> careerPages,String creerLinks) {

		for (String element : careerPages) {
			try{
				if((element.contains("/careers/")||element.contains("/careers")||element.contains("/job"))&&!element.isEmpty())
				{
					String creerPags=element.replace(creerLinks, "");
					if(creerPags.length()>49&&!creerPags.isEmpty())
					{
						if(creerPags.matches(regex))
						{
							if(isUrlValid(creerPags))
							{
								//System.out.println(creerPags);
								getJobPostingInfo(creerPags);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void getJobPostingInfo(String creerPags) {
		Document documnet=null;
		String title=null;
		String description=null;
		try {
			
			documnet=getURLResponse(creerPags);
			//title
			Elements titleElement=documnet.select("meta[property='og:title']");
			if(titleElement!=null&&!titleElement.isEmpty())
			{
				title="";
				title=removeSpecialSymbols(titleElement.attr("content"));
				System.out.println(title);
			}

			//description
			Elements descriptionElement=documnet.select("meta[property='og:description']");
			if(descriptionElement!=null&&!descriptionElement.isEmpty())
			{
				if(descriptionElement.attr("content").length()>15)
				{
					description="";
					description=removeSpecialSymbols(descriptionElement.attr("content"));
					System.out.println(description);
				}
			}

			System.out.println("-------------------------------------------------------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static String removeSpecialSymbols(String inputString) {
		return inputString.replaceAll("[^a-zA-Z0-9\\s\\$\\&\\+\\,\\:\\;\\=\\?\\@\\#\\|\\'\\<\\>\\.\\-\\^\\*\\(\\)\\%\\!]", "");
	}
	
	public static Document getURLResponse(String url) {
		Document documnet=null;
		try {

			SSLExceptionSolution.enableSSLSocket();
			documnet=Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreContentType(true).ignoreHttpErrors(true).get();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return documnet;	
	}



	public static String getCreerLinks1(String urlLink) {
		String news_link=null;
		try {

			Document document=getURLResponse(urlLink);
			String pattern1="(/career/)|(/career)|(/careers/)|(/careers)|(/jobs/)|(/jobs)";
			Elements newsLinks1 =document.getElementsByAttributeValueMatching("href", pattern1);
			if(!newsLinks1.attr("href").isEmpty()) 
			{							
				if(!(newsLinks1.attr("abs:href").contains("wp-content")))
				{
					if(!newsLinks1.attr("abs:href").isEmpty())
					{
						news_link=newsLinks1.attr("abs:href");
					}
				}
			}else {
				news_link="";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return news_link;
	}

	public static boolean isUrlValid(String newsUrl) {

		boolean valid = true;

		try {
			ArrayList<String> wordsList = new ArrayList<String>();
			;
			wordsList.add("facebook");
			wordsList.add("google");
			wordsList.add("twitter");
			wordsList.add("youtube");
			wordsList.add("play");
			wordsList.add("itunes");
			wordsList.add("file");
			wordsList.add("redirect");
			wordsList.add("linkedin.com/company");
			wordsList.add("shareArticle");
			wordsList.add("#");
			wordsList.add("research");
			wordsList.add("resource");
			wordsList.add("video");
			wordsList.add("lang");
			wordsList.add("about");
			wordsList.add("pdf");



			for (String word : wordsList) {
				try {
					if (newsUrl.contains(word)) {
						valid = false;
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
