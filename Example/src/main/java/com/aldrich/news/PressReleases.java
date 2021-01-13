package com.aldrich.news;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;
import com.aldrich.patent.SSLExceptionSolution;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class PressReleases {

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
			Document home_page_document =getURLResponse(urls);
			if (home_page_document != null) {
				// Press Releases
				getPressReleasesInfo(home_page_document, urls);
				
			}

			
		}
	}


	
	public static Document getURLResponse(String news_url) {
		Document document = null;
		try {
			SSLExceptionSolution.enableSSLSocket();
			document = Jsoup.connect(news_url).followRedirects(true).userAgent(PASEConstants.USER_AGENT).timeout(5000)
					.get();
			if (document == null) {
				OkHttpClient client = new OkHttpClient();
				Request request = new Request.Builder().url(news_url).get().addHeader("cache-control", "no-cache")
						.build();
				String jsonResponse = client.newCall(request).execute().body().string();
				document = Jsoup.parse(jsonResponse);
			}
			if (document == null) {
				String line = null;
				String finalline = null;
				URL url = new URL(news_url);
				URLConnection urlConnection = url.openConnection();
				HttpsURLConnection httpsUrlConnection = (HttpsURLConnection) urlConnection;
				urlConnection.setConnectTimeout(5000);
				httpsUrlConnection.setConnectTimeout(5000);
				SSLSocketFactory sslSocketFactory = createSslSocketFactory();
				httpsUrlConnection.setSSLSocketFactory(sslSocketFactory);
				try (InputStream inputStream = httpsUrlConnection.getInputStream()) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
					while ((line = reader.readLine()) != null) {
						finalline = finalline + line;
					}
				}
				document = Jsoup.parse(finalline);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

	public static SSLSocketFactory createSslSocketFactory() throws Exception {
		TrustManager[] byPassTrustManagers = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

			public void checkClientTrusted(X509Certificate[] chain, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] chain, String authType) {
			}
		} };
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, byPassTrustManagers, new SecureRandom());
		return sslContext.getSocketFactory();
	}

	public static void getPressReleasesInfo(Document document, String company_url) {
		try {
			// get the press releases pages
			List<String> pressReleasesUrlList = getPressReleasesUrl(document, company_url);
			if (pressReleasesUrlList.size() > 0) {
				for (String pr_url : pressReleasesUrlList) {
					try {
						System.out.println("------------------------------------");
						System.out.println(pr_url);
						System.out.println("------------------------------------");
						Document individual_pr_document = getURLResponse(pr_url);
						if (individual_pr_document != null) {
							// get ind press releases pages
							List<String> individualPressReleasesUrlList = getAllPressReleasesUrl(individual_pr_document, company_url);
							if (individualPressReleasesUrlList.size() > 0) {
								for (String ind_pr_url : individualPressReleasesUrlList) {
									try {
										if (!pr_url.equals(ind_pr_url)) {
											System.out.println(ind_pr_url);
											Document ind_news_document = getURLResponse(ind_pr_url);
											if (ind_news_document != null) {
												saveNewsInfo(ind_news_document, ind_pr_url,"Press Releases");
											}
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> getPressReleasesUrl(Document document, String company_url) {
		List<String> pressReleasesUrlsList = new ArrayList<String>();
		String page_number = null;
		String is_pages_available = "No";
		String page_nav_type = "";
		int page_num = 0;
		List<Integer> page_num_list = new ArrayList<Integer>();
		try {
			Elements elements = document.select("a");
			if (elements != null && elements.size() > 0) {
				for (Element element : elements) {
					try {
						if (element.hasAttr("href")) {
							String text = element.text().trim().toLowerCase();
							String link = element.attr("href").trim().toLowerCase();
							if (link.contains("/press-release") || link.contains("/press-releases")
									|| link.contains("/press/")) {
								String actual_pr_url = null;
								if (link.startsWith("http")) {
									actual_pr_url = link;
								} else if (link.startsWith("www")) {
									actual_pr_url = "http://" + link;
								} else if (company_url.endsWith("/") && link.startsWith("/")) {
									actual_pr_url = company_url + link.substring(1);
								} else if (!company_url.endsWith("/") && link.startsWith("/")) {
									actual_pr_url = company_url + link;
								} else if (!company_url.endsWith("/") && !link.startsWith("/")) {
									actual_pr_url = company_url + "/" + link;
								} else {
									actual_pr_url = company_url + "/" + link;
								}
								if (actual_pr_url != null && isValidUrl(actual_pr_url) == true) {
									boolean exists = pressReleasesUrlsList.contains(actual_pr_url);
									if (exists == false) {
										pressReleasesUrlsList.add(actual_pr_url);
									}
									Document pr_document = null;
									pr_document = getURLResponse(actual_pr_url);
									if (pr_document != null) {
										Elements anchor_elements = pr_document.select("a");
										if (anchor_elements != null && anchor_elements.size() > 0) {
											for (Element ele : anchor_elements) {
												try {
													if (ele.hasAttr("href")) {
														String text1 = ele.text().trim().toLowerCase();
														String link1 = ele.attr("href").trim().toLowerCase();
														if (link1.contains("/press-release")
																|| link1.contains("/press-releases")
																|| link1.contains("/press/")) {
															if (link1.contains("/page/") || link1.contains("/page")
																	|| link1.contains("page/")
																	|| link1.contains("page=")) {
																if (link1.contains("/page/")
																		|| link1.contains("/page")) {
																	page_nav_type = "/page/";
																}
																if (link1.contains("page=")
																		|| link1.contains("?page=")) {
																	page_nav_type = "page=";
																}
																String actual_pr_url_1 = null;
																if (link1.startsWith("http")) {
																	actual_pr_url_1 = link1;
																} else if (link1.startsWith("www")) {
																	actual_pr_url_1 = "http://" + link1;
																} else if (company_url.endsWith("/")
																		&& link1.startsWith("/")) {
																	actual_pr_url_1 = company_url + link1.substring(1);
																} else if (!company_url.endsWith("/")
																		&& link1.startsWith("/")) {
																	actual_pr_url_1 = company_url + link1;
																} else if (!company_url.endsWith("/")
																		&& !link1.startsWith("/")) {
																	actual_pr_url_1 = company_url + "/" + link1;
																} else {
																	actual_pr_url_1 = company_url + "/" + link1;
																}
																exists = pressReleasesUrlsList
																		.contains(actual_pr_url_1);
																if (exists == false
																		&& isValidUrl(actual_pr_url_1) == true) {
																	is_pages_available = "Yes";
																	page_number = actual_pr_url_1.replaceAll("[^\\d]",
																			" ");
																	page_number = page_number.trim();
																	if (page_number != null
																			&& !page_number.equals("")) {
																		page_num = Integer.parseInt(page_number);
																		page_num_list.add(page_num);
																	}
																	pressReleasesUrlsList.add(actual_pr_url_1);
																}
															}
														}
													}
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										}
									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if (pressReleasesUrlsList.size() > 0) {
				String first_url = pressReleasesUrlsList.get(0);
				if (page_num > 0) {
					page_num = Collections.max(page_num_list);
					for (int pagenum = 0; pagenum < page_num; pagenum++) {
						try {
							if (pagenum != 0) {
								if (is_pages_available.equals("Yes")) {
									String pagination_url = null;
									if (first_url.endsWith("/")) {
										pagination_url = first_url + "page/" + pagenum + "/";
									} else {
										pagination_url = first_url + "/page/" + pagenum + "/";
									}
									boolean exists = pressReleasesUrlsList.contains(pagination_url);
									if (exists == false && isValidUrl(pagination_url) == true) {
										pressReleasesUrlsList.add(pagination_url);
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					for (int pagenum = 0; pagenum < page_num; pagenum++) {
						try {
							if (pagenum != 0) {
								if (is_pages_available.equals("Yes")) {
									String pagination_url = null;
									if (page_nav_type.equals("page=")) {
										if (first_url.endsWith("/")) {
											pagination_url = first_url + "?page=" + pagenum;
										} else {
											pagination_url = first_url + "?page=" + pagenum;
										}
									}
									boolean exists = pressReleasesUrlsList.contains(pagination_url);
									if (exists == false && isValidUrl(pagination_url) == true) {
										pressReleasesUrlsList.add(pagination_url);
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> newList = pressReleasesUrlsList.stream().distinct().collect(Collectors.toList());
		return newList;
	}

	public static boolean isValidUrl(String page_url) {
		boolean valid = true;
		try {
			if (page_url.contains("www.facebook.com") || page_url.contains("www.linkedin.com")
					|| page_url.contains("plus.google.com") || page_url.contains("twitter.com")
					|| page_url.contains("?") || page_url.contains(".pdf")) {
				valid = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

	public static  List<String> getAllPressReleasesUrl(Document document, String company_url) {
		List<String> pressReleasesUrlsList = new ArrayList<String>();
		try {
			Elements elements = document.select("a");
			if (elements != null && elements.size() > 0) {
				for (Element element : elements) {
					try {
						if (element.hasAttr("href")) {
							String text = element.text().trim().toLowerCase();
							String link = element.attr("href").trim().toLowerCase();
							if (link.contains("press-release") || link.contains("press-releases")
									|| link.contains("www.prnewswire.com") || link.contains("www.businesswire.com")
									|| link.contains("www.przoom.com") || link.contains("www.prurgent.com")
									|| link.contains("www.pr.com") || link.contains("www.prweb.com")
									|| link.contains("/releases/") || link.contains("/news-releases/")
									|| link.contains("/news-release/") || link.contains("/release/")
									|| link.contains("/press/")) {
								String actual_pr_url = null;
								if (link.startsWith("http")) {
									actual_pr_url = link;
								} else if (link.startsWith("www")) {
									actual_pr_url = "http://" + link;
								} else if (company_url.endsWith("/") && link.startsWith("/")) {
									actual_pr_url = company_url + link.substring(1);
								} else if (!company_url.endsWith("/") && link.startsWith("/")) {
									actual_pr_url = company_url + link;
								} else if (!company_url.endsWith("/") && !link.startsWith("/")) {
									actual_pr_url = company_url + "/" + link;
								} else {
									actual_pr_url = company_url + "/" + link;
								}
								if (actual_pr_url != null && isValidUrl(actual_pr_url) == true) {
									if (!actual_pr_url.contains("/page/") && !actual_pr_url.contains("/page")
											&& !actual_pr_url.contains("page/") && !actual_pr_url.contains("page=")) {
										boolean exists = pressReleasesUrlsList.contains(actual_pr_url);
										if (exists == false) {
											pressReleasesUrlsList.add(actual_pr_url);
										}
									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> newList = pressReleasesUrlsList.stream().distinct().collect(Collectors.toList());
		return newList;
	}
	
	public static void saveNewsInfo(Long company_id, Document document, String news_link, String category) {
		String news_title = null;
		String news_desc = null;
		String news_date = null;
		String news_date_temp = null;
		Date pub_date = null;
		try {
			Elements meta_elements = document.select("meta");
			if (meta_elements != null && meta_elements.size() > 0) {
				for (Element element : meta_elements) {
					if (element.hasAttr("property") && element.attr("property").equals("og:title")
							&& element.hasAttr("content")) {
						news_title = element.attr("content").trim();
					}
					if (element.hasAttr("name") && element.attr("name").equals("title") && element.hasAttr("content")) {
						news_title = element.attr("content").trim();
					}
					if (element.hasAttr("property") && element.attr("property").equals("og:description")
							&& element.hasAttr("content")) {
						news_desc = element.attr("content").trim();
					}
					if (element.hasAttr("name") && element.attr("name").equals("description")) {
						news_desc = element.attr("content").trim();
					}
					if (element.hasAttr("property") && element.attr("property").equals("article:published_time")
							&& element.hasAttr("content")) {
						news_date = element.attr("content").trim();
					}
					if (element.hasAttr("property") && element.attr("property").equals("article:published")
							&& element.hasAttr("content")) {
						news_date = element.attr("content").trim();
					}
					if (element.hasAttr("itemprop") && element.attr("itemprop").equals("datePublished")
							&& element.hasAttr("content")) {
						news_date = element.attr("content").trim();
					}
				}
			}
			if (news_date != null) {
				String dateArray[] = news_date.split("T");
				if (dateArray[0] != null && !dateArray[0].isEmpty()) {
					pub_date = convertAnyTypeDateToSingleFormat(dateArray[0]);
					news_date_temp = dateArray[0];
				}
			} else {
				if (meta_elements != null && meta_elements.size() > 0) {
					for (Element element : meta_elements) {
						if (element.hasAttr("property") && element.attr("property").equals("article:modified_time")
								&& element.hasAttr("content")) {
							news_date = element.attr("content").trim();
							String dateArray[] = news_date.split("T");
							if (dateArray[0] != null && !dateArray[0].isEmpty()) {
								pub_date = convertAnyTypeDateToSingleFormat(dateArray[0]);
								news_date_temp = dateArray[0];
							}
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static Date convertAnyTypeDateToSingleFormat(String dateInString) {
		String dateFormat = null;
		Date date = null;
		String regex1 = "\\d{4,4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
		String regex2 = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/\\d{4,4}";
		String regex3 = "(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])\\/\\d{4,4}";
		String regex4 = "(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])\\-\\d{4,4}";
		String regex5 = "(0?[1-9]|[12][0-9]|3[01])\\-(0?[1-9]|1[012])\\-\\d{4,4}";
		String regex6 = "\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex7 = "(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}";
		String regex8 = "(0?[1-9]|[12][0-9]|3[01])\\-(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\-\\d{4,4}";
		String regex9 = "(0?[1-9]|[12][0-9]|3[01])\\,\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}";
		String regex10 = "(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{4,4}";
		String regex11 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}";
		String regex12 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}";
		String regex13 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}";
		String regex14 = "[A-Za-z]{3,9}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{1,2}\\s\\d{4,4}";
		String regex15 = "(0?[1-9]|[12][0-9]|3[01])\\s(0?[1-9]|1[012])\\s\\d{4,4}";
		String regex16 = "\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex17 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\.\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}";

		dateInString = dateInString.toLowerCase().replace("t.", "").replace("th", "").replace("nd", "");
		if (dateInString != null && !dateInString.isEmpty()) {
			if (dateInString.matches(regex1)) {
				dateFormat = "yyyy-MM-dd";
			} else if (dateInString.matches(regex2)) {
				dateFormat = "dd/MM/yyyy";
			} else if (dateInString.matches(regex3)) {
				dateFormat = "MM/dd/yyyy";
			} else if (dateInString.matches(regex4)) {
				dateFormat = "MM-dd-yyyy";
			} else if (dateInString.matches(regex5)) {
				dateFormat = "dd-MM-yyyy";
			} else if (dateInString.matches(regex6)) {
				dateFormat = "yyyy/MM/dd";
			} else if (dateInString.matches(regex7.toLowerCase())) {
				dateFormat = "dd MMM yyyy";
			} else if (dateInString.matches(regex8.toLowerCase())) {
				dateFormat = "dd-MMM-yyyy";
			} else if (dateInString.matches(regex9.toLowerCase())) {
				dateFormat = "dd, MMM yyyy";
			} else if (dateInString.matches(regex10.toLowerCase())) {
				dateFormat = "dd MMM, yyyy";
			} else if (dateInString.matches(regex11.toLowerCase())) {
				dateFormat = "MMM dd yyyy";
			} else if (dateInString.matches(regex12.toLowerCase())) {
				dateFormat = "MMM, dd yyyy";
			} else if (dateInString.matches(regex13.toLowerCase())) {
				dateFormat = "MMM dd, yyyy";
			} else if (dateInString.matches(regex14.toLowerCase())) {
				dateFormat = "E MMM, dd yyyy";
			} else if (dateInString.matches(regex15)) {
				dateFormat = "dd MM yyyy";
			} else if (dateInString.matches(regex16)) {
				dateFormat = "yyyy/MM/dd";
			} else if (dateInString.matches(regex17)) {
				dateFormat = "MMM. dd, yyyy";
			} else if ((dateInString).matches(regex13.toLowerCase())) {
				dateFormat = "MMM dd, yyyy";
			}
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			try {
				date = formatter.parse(dateInString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}
	
	public static void saveNewsInfo(Document document, String news_link, String category) {
		String news_title = null;
		String news_desc = null;
		String news_date = null;
		String news_date_temp = null;
		Date pub_date = null;
		try {
			Elements meta_elements = document.select("meta");
			if (meta_elements != null && meta_elements.size() > 0) {
				for (Element element : meta_elements) {
					if (element.hasAttr("property") && element.attr("property").equals("og:title")
							&& element.hasAttr("content")) {
						news_title = element.attr("content").trim();
					}
					if (element.hasAttr("name") && element.attr("name").equals("title") && element.hasAttr("content")) {
						news_title = element.attr("content").trim();
					}
					if (element.hasAttr("property") && element.attr("property").equals("og:description")
							&& element.hasAttr("content")) {
						news_desc = element.attr("content").trim();
					}
					if (element.hasAttr("name") && element.attr("name").equals("description")) {
						news_desc = element.attr("content").trim();
					}
					if (element.hasAttr("property") && element.attr("property").equals("article:published_time")
							&& element.hasAttr("content")) {
						news_date = element.attr("content").trim();
					}
					if (element.hasAttr("property") && element.attr("property").equals("article:published")
							&& element.hasAttr("content")) {
						news_date = element.attr("content").trim();
					}
					if (element.hasAttr("itemprop") && element.attr("itemprop").equals("datePublished")
							&& element.hasAttr("content")) {
						news_date = element.attr("content").trim();
					}
				}
			}
			if (news_date != null) {
				String dateArray[] = news_date.split("T");
				if (dateArray[0] != null && !dateArray[0].isEmpty()) {
					pub_date = convertAnyTypeDateToSingleFormat(dateArray[0]);
					news_date_temp = dateArray[0];
				}
			} else {
				if (meta_elements != null && meta_elements.size() > 0) {
					for (Element element : meta_elements) {
						if (element.hasAttr("property") && element.attr("property").equals("article:modified_time")
								&& element.hasAttr("content")) {
							news_date = element.attr("content").trim();
							String dateArray[] = news_date.split("T");
							if (dateArray[0] != null && !dateArray[0].isEmpty()) {
								pub_date = convertAnyTypeDateToSingleFormat(dateArray[0]);
								news_date_temp = dateArray[0];
							}
						}
					}
				}
			}
			if (!news_title.isEmpty() && !news_desc.isEmpty()) {
				System.out.println(news_title);
				System.out.println(news_desc);
				System.out.println(news_date);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
