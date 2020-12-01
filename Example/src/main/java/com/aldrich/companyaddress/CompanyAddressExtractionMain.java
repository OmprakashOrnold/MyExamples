package com.aldrich.companyaddress;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.FormatUrl;
import com.aldrich.pase.util.PASEConstants;
import com.aldrich.pase.util.RegularExpressionUtils;

public class CompanyAddressExtractionMain {
	public static void main(String[] args) {

		String regex = "(\\d{1,})[ ]?[a-zA-Z0-9.,\\s]+(\\.)?[ ]?[a-zA-Z]+(\\,)?[ ]?[A-Z]{2}[ ]?[0-9]{5,6}|[0-9]{5}(?:-[0-9]{4})?+";
		Pattern pattern = Pattern.compile(regex);

		String addressReq=null;

		String address_pattern = "(contact-us|contact us|contact-us.html|contact|about|support)+";

		Document documnet = null;
		List<String> addressq = new ArrayList<String>();



		addressq.add("https://www.w2globaldata.com/");
		addressq.add("http://Aribex.com");
		addressq.add("	https://www.alliedwallet.com/	");
		addressq.add("https://saw-grass.com/");
		addressq.add("	http://www.archoninfosys.com	");
		addressq.add("	https://www.callingmart.com/	");
		addressq.add("	http://www.assurancefa.com	");
		addressq.add("	http://www.vistaimagingservices.com	");
		addressq.add("	http://keepcalling.net/	");
		addressq.add("	https://www.efwnow.com/	");
		addressq.add("	https://kellermortgage.com/	");
		addressq.add("	https://www.verusboc.com/	");
		addressq.add("	https://crescendrf.com/	");
		addressq.add("	https://nlogic.com/	");
		addressq.add("	http://utilipath.com	");
		addressq.add("	http://Aribex.com	");
		addressq.add("	http://www.wcslending.com	");
		addressq.add("	http://www.expertsit.com	");
		addressq.add("	https://www.ifgsd.com/	");
		addressq.add("	http://www.bristleconeadvisors.com	");
		addressq.add("	http://www.intrustgroup.com	");
		addressq.add("	https://www.rtsav.com/	");
		addressq.add("	https://www.asset-security-pro.com/	");
		addressq.add("	https://www.sentryprotectsyou.com/	");
		addressq.add("	http://www.technosecure.com	");
		addressq.add("	http://www.uscarrier.com	");
		addressq.add("	https://www.inboxdollars.com/	");
		addressq.add("	blogspot.com	");
		addressq.add("	symptomfind.com	");
		addressq.add("	prevention.com	");
		addressq.add("	canon.com	");
		addressq.add("	logmein.com	");
		addressq.add("	informars.com	");
		addressq.add("	jstor.org	");
		addressq.add("	self.com	");
		addressq.add("	helprx.info	");
		addressq.add("	fitpregnancy.com	");
		addressq.add("	digitalpoint.com	");
		addressq.add("	uk.com	");
		addressq.add("	healingwell.com	");
		addressq.add("	lifestylelift.com	");
		addressq.add("	askdrsears.com	");
		addressq.add("	https://www.brighthub.com/	");
		addressq.add("	websitetoolbox.com	");
		addressq.add("	https://corp.viewbix.com/	");
		addressq.add("	momtastic.com	");
		addressq.add("	healthaliciousness.com	");
		addressq.add("	md-health.com	");
		addressq.add("	https://wego.here.com/traffic	");
		addressq.add("	padiact.com	");
		addressq.add("	justcloud.com	");
		addressq.add("	patientfusion.com	");
		addressq.add("	http://www.wayport.net	");
		addressq.add("	talentedk12.com	");
		addressq.add("	wepay.com	");
		addressq.add("	auctionflex.com	");
		addressq.add("	rrd.com	");
		addressq.add("	axill.com	");
		addressq.add("	https://www.wirewax.com/	");
		addressq.add("	wellnessmama.com	");
		addressq.add("	freeadvice.com	");
		addressq.add("	userreport.com	");
		addressq.add("	followmyhealth.com	");
		addressq.add("	endocrineweb.com	");
		addressq.add("	ticketplatform.com	");
		addressq.add("	123contactform.com	");
		addressq.add("	https://www.outdoorhub.com/	");
		addressq.add("	mommyish.com	");
		addressq.add("	diabeticlivingonline.com	");
		addressq.add("	sheppardsoftware.com	");
		addressq.add("	rodalenews.com	");
		addressq.add("	jalbum.net	");
		addressq.add("	easylocator.net	");
		addressq.add("	yogawiz.com	");
		addressq.add("	nsw.gov.au	");
		addressq.add("	secure-res.com	");
		addressq.add("	cincopa.com	");
		addressq.add("	https://www.diy.com/	");
		addressq.add("	livezilla.net	");
		addressq.add("	https://www.clickdesk.com/	");
		addressq.add("	supplementwarehouse.com	");
		addressq.add("	hipaaspace.com	");
		addressq.add("	turn-page.com	");
		addressq.add("	forecast.io	");
		addressq.add("	weelicious.com	");
		addressq.add("	xsplit.com	");
		addressq.add("	blipstar.com	");
		addressq.add("	clear-reports.com	");
		addressq.add("	windsurfercrs.com	");
		addressq.add("	internetdrugcoupons.com	");
		addressq.add("	fitlife.tv	");
		addressq.add("	https://www.plugnpay.com/	");
		addressq.add("	https://www.pureorthodontics.ca/	");
		addressq.add("	http://www.artifacttechnologies.com	");
		addressq.add("	https://www.marcomnewmedia.com/	");
		addressq.add("	http://www.3ten8.com	");
		addressq.add("	http://www.pedal.io/	");
		addressq.add("	http://androsolve.blogspot.com/	");
		addressq.add("	http://www.nxlink.com	");
		addressq.add("	http://www.medpathsolutions.com	");
		addressq.add("	http://www.cureia.com	");
		addressq.add("	http://www.mariammedical.com/index.html	");
		addressq.add("	https://www.buildmybod.com/	");
		addressq.add("	https://datavisu.al/	");
		addressq.add("	http://www.tradingvolatility.net/p/home_3.html	");
		addressq.add("	http://www.fitrock.com	");
		addressq.add("	https://www.stepscan.com/	");
		addressq.add("	http://www.carrot.mx	");
		addressq.add("	https://tyadvisory.wixsite.com/home	");
		addressq.add("	http://www.aeropointaviationsys.com	");
		addressq.add("	http://www.houseaccountfunding.com	");
		addressq.add("	http://freshcrop.com/	");
		addressq.add("	http://precisionmedicaldevices.com/	");
		addressq.add("	http://www.zumicare.com	");
		addressq.add("	http://www.saibusresearch.com	");
		addressq.add("	http://www.wellthrewards.com/	");
		addressq.add("	http://thebralady.blogspot.com/	");
		addressq.add("	http://www.pniinstitute.org/2013_deal_stream_summit.html	");
		addressq.add("	http://www.pocketschange.com	");
		addressq.add("	https://www.plensat.com/	");
		addressq.add("	http://www.futureperfect.me/	");
		addressq.add("	https://www.647dialart.com/	");
		addressq.add("	http://purposeandelegance.com?password-protected=login&redirect_to=http%3a%2f%2fwww.purposeandelegance.com%2f	");
		addressq.add("	http://www.directedvision.com/	");
		addressq.add("	https://verifip.com/	");
		addressq.add("	https://www.neuronhighway.com/	");
		addressq.add("	http://www.sentdex.com	");
		addressq.add("	https://www.planancial.com/	");
		addressq.add("	http://www.lupobusiness.com	");
		addressq.add("	http://www.mentormarkets.net	");
		addressq.add("	http://www.dosi.io	");
		addressq.add("	http://haulstudios.com	");
		addressq.add("	http://www.financier.com/	");
		addressq.add("	http://www.innerspaceneuro.com	");
		addressq.add("	http://www.klinkmobile.com	");
		addressq.add("	http://www.statnum.com/	");
		addressq.add("	https://www.visuafy.com/	");
		addressq.add("	http://www.memberrx.com	");
		addressq.add("	http://www.babaramdevproducts.com/	");
		addressq.add("	https://www.stherbb.us/	");
		addressq.add("	http://www.herbalcureindia.com	");
		addressq.add("	http://www.stocktagon.com	");
		addressq.add("	https://cardup.co/	");
		addressq.add("	https://www.logrr.com/	");
		addressq.add("	http://www.enhsc.com	");
		addressq.add("	https://pixelatto.com/reventure	");
		addressq.add("	http://www.gobstopper.com	");
		addressq.add("	https://mall.myuwell.com/	");
		addressq.add("	https://dmaclt.com/	");
		addressq.add("	http://asknaturalhealth.ca/	");
		addressq.add("	http://www.vmh.com/garyl3.aspx	");
		addressq.add("	http://www.sportslever.com	");
		addressq.add("	https://jaystack.com/	");
		addressq.add("	http://www.zeitic.com	");
		addressq.add("	https://medberi.com/	");
		addressq.add("	http://www.emergingdomains.com/	");
		addressq.add("	https://www.stumpworx.com/	");
		addressq.add("	https://www.vvvcap.com/	");
		addressq.add("	http://www.bookmedoc.com/	");
		addressq.add("	http://in development	");
		addressq.add("	https://www.unisender.com/	");
		addressq.add("	http://www.hirevuelabs.com	");
		addressq.add("	https://www.dropcatch.com/domain/vantagerealized.com	");
		addressq.add("	https://www.francescobertelli.com/	");
		addressq.add("	http://hcm.launchrock.com/	");
		addressq.add("	http://www.realmds.com/	");
		addressq.add("	http://www.lifevesthealth.com	");
		addressq.add("	https://www.thennt.com/	");
		addressq.add("	http://www.mangesius.com	");
		addressq.add("	https://davidwever.com/	");
		addressq.add("	http://www.ubtane.com	");
		addressq.add("	https://credsimple.herokuapp.com/	");
		addressq.add("	https://www.prenostik.com/	");
		addressq.add("	https://mail-attachment.googleusercontent.com/attachment/u/0/?ui=2&ik=9df7b60d92&view=att&th=138db5e85b4772f3&attid=0.1&disp=inline&realattid=f_h5aicsma1&safe=1&zw&saduie=ag9b_p89wwclmb5kih54hy8faapo&sadet=1346173137013&sads=lyzmk4y2v2vaer91u4urnixphhc&s...	");
		addressq.add("	https://www.swiftrelay.com	");
		addressq.add("	http://www.shieldiagnostics.com	");
		addressq.add("	https://www.getartemis.com/	");
		addressq.add("	http://getcinetic.com/	");
		addressq.add("	http://www.metradbiosystems.com	");
		addressq.add("	http://www.pivott.com	");
		addressq.add("	http://www.nusomnea.com/	");
		addressq.add("	http://www.clinitrial.com	");
		addressq.add("	http://www.composedit.com	");
		addressq.add("	http://inrtracker.com/	");
		addressq.add("	http://ffff.com	");
		addressq.add("	http://www.agoramed.net	");
		addressq.add("	https://lavernedouglastechnologies.com/	");
		addressq.add("	https://www.snapinspect.com/	");
		addressq.add("	https://bioinvaders.com/	");
		addressq.add("	http://www.optumsurgical.com/	");
		addressq.add("	http://www.firstopinion.co/fpbtg/	");
		addressq.add("	http://www.besttaxpreparers.com	");
		addressq.add("	https://www.perfectore.com/	");
		addressq.add("	https://outdoorevents.us	");
		addressq.add("	http://www.habitid.com	");
		addressq.add("	http://www.passportfx.com/	");
		addressq.add("	http://www.nutritashealth.com	");
		addressq.add("	https://psycholate.com/	");
		addressq.add("	http://professionalperformance.ca	");
		addressq.add("	http://www.insurancemanager.gr	");
		addressq.add("	http://localheros.net/localheros/main_page.html	");
		addressq.add("	http://www.tickitforhealth.com	");
		addressq.add("	http://iecorp.co/	");
		addressq.add("	https://restadesk.com/	");
		addressq.add("	http://www.bzcareer.com	");
		addressq.add("	https://www.linknovate.com/	");
		addressq.add("	http://www.cardiacprofiles.com	");
		addressq.add("	https://cashboardapp.com/	");
		addressq.add("	https://www.getsendtask.com/	");
		addressq.add("	http://www.prettypaddedroom.com	");
		addressq.add("	https://www.brandflip.com/domain/99companies.com	");
		addressq.add("	http://www.oblixventures.com	");
		addressq.add("	http://www.medconcept.ca	");
		addressq.add("	http://www.answerok.com	");
		addressq.add("	http://spineshark.com/	");
		addressq.add("	https://www.mindluxe.com	");
		addressq.add("	http://www.jibecast.com	");
		addressq.add("	http://www.ecollectohio.com	");
		addressq.add("	http://www.poisson-chat.com	");
		addressq.add("	http://www.consultingmd.com	");
		addressq.add("	http://menopausechitchat.com/	");
		addressq.add("	http://www.fortunamedical.com	");
		addressq.add("	https://arcanecapital.autotradenow.com/	");
		addressq.add("	https://healthycrowdfunder.wordpress.com/	");
		addressq.add("	http://www.castcoverultra.com/	");
		addressq.add("	https://tests4geeks.com	");
		addressq.add("	http://www.dentist.ly	");
		addressq.add("	http://www.svbio.com	");
		addressq.add("	https://www.skipoapp.com/	");
		addressq.add("	https://simpleprogrammer.com/	");
		addressq.add("	http://www.igenezen.com	");
		addressq.add("	http://westernstatesbiopharm.com	");
		addressq.add("	http://www.gotalpha.com	");
		addressq.add("	http://heidismoneymakingblog.blogspot.com/	");
		addressq.add("	http://www.prospectware.com	");
		addressq.add("	http://www.optimino.com	");
		addressq.add("	https://elioplus.com/	");
		addressq.add("	https://patientcarenet.org/	");
		addressq.add("	http://adam-shedek.blogspot.com/	");
		addressq.add("	http://www.healthenclave.com	");
		addressq.add("	http://www.cnicus.com	");
		addressq.add("	http://www.walshfamilymedia.com	");
		addressq.add("	http://www.improveposturenow.com	");
		addressq.add("	http://www.novitacare.com	");
		addressq.add("	http://www.houstonfinancialcenter.com/disclaimer.cfm?target=index.cfm?	");
		addressq.add("	http://www.computernetonline.com	");
		addressq.add("	http://langstonfinancial.com/	");
		addressq.add("	http://www.accelereyes.com	");
		addressq.add("	http://www.sankatyhealth.com	");
		addressq.add("	http://www.vidigami.com	");
		addressq.add("	http://www.beondesk.com	");
		addressq.add("	http://www.grofolio.com/uknup/npcmv/	");
		addressq.add("	http://www.curepatch.com	");
		addressq.add("	http://www.nestegger.com/	");
		addressq.add("	http://blueprinthealth.net	");
		addressq.add("	https://www.autotax.me/	");
		addressq.add("	http://www.qcard.ca	");
		addressq.add("	http://www.mindfulnets.co/end-tables-with-storage/	");
		addressq.add("	http://www.foundersunder40.com	");
		addressq.add("	https://www.getosmosis.com/	");
		addressq.add("	https://www.rooof.com	");
		addressq.add("	http://www.therounds.ca	");
		addressq.add("	https://bigbluebutton.org/	");
		addressq.add("	http://www.stacksearch.com	");
		addressq.add("	http://www.qlabs.com	");
		addressq.add("	http://www.madapparelinc.com	");
		addressq.add("	https://pinechiropracticcenter.com/	");
		addressq.add("	http://www.voip-1.com	");
		addressq.add("	http://www.thinkdirtyshopclean.com	");
		addressq.add("	http://www.structuredbioequity.com	");
		addressq.add("	https://www.stridelab.com	");
		addressq.add("	https://www.facenote.me/	");
		addressq.add("	http://taskassure.com/	");
		addressq.add("	http://www.winningdiabetics.com/blank.html	");
		addressq.add("	https://www.speedbiosystems.com/	");
		addressq.add("	http://www.traderrs.com/	");
		addressq.add("	http://www.boogg.com	");
		addressq.add("	https://beehively.com:443/	");
		addressq.add("	https://www.momedx.com/	");
		addressq.add("	http://www.jointly.io	");
		addressq.add("	http://www.voxce.com/	");
		addressq.add("	https://kickvox.com/	");
		addressq.add("	http://www.intellicoin.com/i/construction	");
		addressq.add("	http://www.medchoicefinancial.com	");
		addressq.add("	https://www.kostizi.com/	");
		addressq.add("	http://www.genicell.co	");
		addressq.add("	http://www.docwi.se	");
		addressq.add("	http://www.copular.com	");
		addressq.add("	https://www.boletia.com/	");
		addressq.add("	http://www.swamiengineered.com	");
		addressq.add("	http://www.avanzagroup.net	");
		addressq.add("	http://www.crispmedia.com	");
		addressq.add("	http://www.credilogic.com	");
		addressq.add("	http://www.jackalopejobs.com/	");
		addressq.add("	http://www.tapthecap.com	");
		addressq.add("	http://www.healthyplatforms.com/	");
		addressq.add("	http://www.changeitcanada.com	");
		addressq.add("	https://www.datecheckpro.com/	");
		addressq.add("	https://www.mybodystructure.com/	");
		addressq.add("	http://www.thefundersclub.com	");
		addressq.add("	https://pillcontainers.com/	");
		addressq.add("	http://www.logfrogapp.com/	");
		addressq.add("	https://wpappstore.com/	");
		addressq.add("	https://www.horizonvascularspecialists.com/	");
		addressq.add("	http://www.drift.io	");
		addressq.add("	http://www.assistanceprofessionals.com	");
		addressq.add("	http://www.mylicensebuddy.com	");
		addressq.add("	http://privatemoneybanks.com/	");
		addressq.add("	http://www.tippybob.com	");
		addressq.add("	http://www.easycooking.in	");
		addressq.add("	https://www.healthoptionsworldwide.com/	");
		addressq.add("	http://www.figsscrubs.com/	");
		addressq.add("	https://healthtechhatch.com/	");
		addressq.add("	http://www.informedika.com	");
		addressq.add("	http://www.sageworksinc.com	");
		addressq.add("	http://alphamaleinfo.com/	");
		addressq.add("	https://warp.ly/	");
		addressq.add("	https://www.budgetsimple.com/	");
		addressq.add("	http://www.energysolutionsforum.com	");
		addressq.add("	http://www.learnup.me	");
		addressq.add("	http://www.silverliving.com/?utm_source=angel&utm_medium=angel&utm_campaign=angel	");
		addressq.add("	http://www.30daystosanity.com	");
		addressq.add("	http://www.venddo.com	");
		addressq.add("	http://www.hourglasstech.com	");
		addressq.add("	https://peoplegeniuscoaching.com/	");
		addressq.add("	https://www.prebacked.com/	");
		addressq.add("	https://www.fairtradecertified.org	");
		addressq.add("	http://dayflier.com/	");
		addressq.add("	http://aurametrix.com/	");
		addressq.add("	http://www.fusionpipe.com	");
		addressq.add("	https://thecalyxgroup.com/	");
		addressq.add("	https://hydracoach.com/	");
		addressq.add("	https://www.eternitywarriorfit.com/	");
		addressq.add("	http://premise.is/	");
		addressq.add("	http://www.cimamgt.com	");
		addressq.add("	http://www.odexgroup.com	");
		addressq.add("	http://www.michaelschildrenshospital.com	");
		addressq.add("	https://www.cryptophoto.com/	");
		addressq.add("	http://www.gimmee.co/	");
		addressq.add("	http://www.accesstreasury.com	");
		addressq.add("	http://www.hardheadedmedia.com	");
		addressq.add("	http://www.spqs.com	");
		addressq.add("	http://www.schedfull.com	");
		addressq.add("	http://www.beyond84.com	");
		addressq.add("	http://www.brightmindsgroup.com/	");
		addressq.add("	http://www.datafiniti.net	");
		addressq.add("	https://corp.owler.com	");
		addressq.add("	https://www.bonestation.com/	");
		addressq.add("	http://www.net-worth.com	");
		addressq.add("	http://www.chartlabpro.com/home	");
		addressq.add("	http://homehealthcareassistance.com	");
		addressq.add("	http://www.etuda.com	");
		addressq.add("	https://www.scotas.com/	");
		addressq.add("	http://vacationrentalpartner.com/	");
		addressq.add("	https://www.taylannas.com/	");
		addressq.add("	http://www.structured-settlements.net/	");
		addressq.add("	https://usingcellphones.com/ed-sf/?id=wfh11-wrk-swps	");
		addressq.add("	http://www.advancedhealinginstitute.com	");
		addressq.add("	http://www.seniorxscape.com	");
		addressq.add("	http://www.tradified.com/	");
		addressq.add("	https://frogtek.org/	");
		addressq.add("	https://lumino.so:443/	");
		addressq.add("	http://www.sharefund.com/	");
		addressq.add("	https://www.mightybell.com/	");
		addressq.add("	http://www.sympl.com/	");
		addressq.add("	https://www.incultureparent.com/	");
		addressq.add("	https://allthingsbugs.com/	");
		addressq.add("	http://www.redrobot.com/	");
		addressq.add("	https://www.damps.com/	");
		addressq.add("	http://brightworkcoresearch.com/	");
		addressq.add("	http://www.healthsurance.com	");
		addressq.add("	http://www.apollodiagnostics.com	");
		addressq.add("	http://www.cleancrowd.com	");
		addressq.add("	https://davkablog.wordpress.com/	");
		addressq.add("	https://www.recoverydatabase.net	");
		addressq.add("	https://www.mueslifusion.com/	");
		addressq.add("	http://www.pedicineapp.com	");
		addressq.add("	https://www.cubedrive.com/	");
		addressq.add("	http://www.envisionitperfect.com	");
		addressq.add("	http://www.imedsolution.biz	");
		addressq.add("	https://about.yorn.com/	");
		addressq.add("	http://www.careworkforce.com	");
		addressq.add("	https://checkeeper.com/	");
		addressq.add("	https://www.getbridge.com	");
		addressq.add("	https://www.nicereply.com/	");
		addressq.add("	http://www.pxlc.me	");
		addressq.add("	https://thesilverstep.com/	");
		addressq.add("	https://www.job-mart.com/	");
		addressq.add("	https://www.swipechart.com	");
		addressq.add("	http://www.drmarion.com	");
		addressq.add("	https://www.kloudtalk.com/	");
		addressq.add("	https://medchart.co/	");
		addressq.add("	http://www.nervcell.com	");
		addressq.add("	https://healthbee.co/	");
		addressq.add("	http://www.playrific.com	");
		addressq.add("	https://www.zaahah.com/	");
		addressq.add("	https://edmondsoncapital.com/	");
		addressq.add("	http://www.gravitypower.net	");
		addressq.add("	https://www.yclients.com/	");
		addressq.add("	http://www.healthyus.com	");
		addressq.add("	https://wooboard.com/	");
		addressq.add("	http://www.feestofunds.com	");
		addressq.add("	https://www.hatchpoint.com/	");
		addressq.add("	http://www.elfamed.com	");
		addressq.add("	http://www.zafirro.com	");
		addressq.add("	http://www.commercialcreditratings.com/gqzyk/obnlr/	");
		addressq.add("	https://www.waitingroomapp.com/	");
		addressq.add("	http://www.weebrag.com	");
		addressq.add("	http://www.emergium.com	");
		addressq.add("	https://www.justaskanurse.com/	");
		addressq.add("	http://www.wibeamusa.com	");
		addressq.add("	http://www.asset.vc	");
		addressq.add("	http://www.knuman.com/?utm_source=angellist	");
		addressq.add("	http://www.biopurgo.com	");
		addressq.add("	https://www.youtube.com/watch?v=6ugxxqzp72o	");
		addressq.add("	http://www.synergywellnessclinic.com	");
		addressq.add("	https://na9.salesforce.com/	");
		addressq.add("	https://www.excelerol.com/	");
		addressq.add("	https://mobodelivery.com/	");
		addressq.add("	http://www.xxx.	");
		addressq.add("	http://www.dreamcommerce.co	");
		addressq.add("	http://www.iseeboard.com	");
		addressq.add("	http://www.tinmansystems.com	");
		addressq.add("	https://domain-for-sale.vereo.com/domain/shopforcare.com/	");
		addressq.add("	http://www.sylion.com	");
		addressq.add("	https://www.get-bitcoin.com/	");
		addressq.add("	https://designbyrobots.com/	");
		addressq.add("	https://www.veroot.com:443/	");
		addressq.add("	https://equityassetmanagement.co/	");
		addressq.add("	http://www.wallstreetwarrior.net/index_1026.php	");
		addressq.add("	https://www.thermodata.us/	");
		addressq.add("	https://www.rawelementsusa.com/	");
		addressq.add("	http://www.marketvalued.com	");
		addressq.add("	http://www.iamheronline.com/	");
		addressq.add("	https://qwikwire.com/	");
		addressq.add("	http://www.401kprep.com	");
		addressq.add("	http://www.sciomd.com/cgi-sys/suspendedpage.cgi	");
		addressq.add("	https://walleyetechnologies.com/	");
		addressq.add("	http://www.emednotes.com	");
		addressq.add("	http://www.cloudbill.com	");
		addressq.add("	http://www.flashvalet.com	");
		addressq.add("	http://www.mural.ly	");
		addressq.add("	http://www.invertual.com	");
		addressq.add("	http://www.n8tion.com/	");
		addressq.add("	http://www.payswyft.com	");
		addressq.add("	http://www.clinicalmt.com/	");
		addressq.add("	http://www.noatta.com	");
		addressq.add("	http://www.americanhcl.com	");
		addressq.add("	https://www.lombardilift.com/	");
		addressq.add("	https://www.voicefriend.net/	");
		addressq.add("	https://fittogether.com/	");
		addressq.add("	http://www.fastrobotics.com	");
		addressq.add("	http://www.groupizesolutions.com	");
		addressq.add("	https://ospreyinformatics.com/	");
		addressq.add("	https://www.zytrel.com	");
		addressq.add("	http://www.quickdropit.com/	");
		addressq.add("	http://www.ineuroskill.com	");
		addressq.add("	http://www.physician2patient.net	");
		addressq.add("	http://www.classtivity.com	");
		addressq.add("	http://www.inquicity.com	");
		addressq.add("	http://www.acceleratedmedicaldiagnostics.com	");
		addressq.add("	https://www.sqlvox.com/	");
		addressq.add("	http://www.groundswellhealth.com	");
		addressq.add("	https://www.datatekanalytics.com/	");
		addressq.add("	http://www.mycoconutcream.com	");
		addressq.add("	http://www.sexgodrocknroll.com/	");
		addressq.add("	https://bluecardpayments.com/	");
		addressq.add("	http://www.smartsignin.com	");
		addressq.add("	https://rxestore.com/	");
		addressq.add("	http://www.evosol.co	");
		addressq.add("	http://getoget.com/	");
		addressq.add("	http://www.theroyaltyexchange.com	");
		addressq.add("	https://barbertechs.com/	");
		addressq.add("	http://www.mediamarketingconsultants.com	");
		addressq.add("	http://www.lendingarc.com	");
		addressq.add("	http://www.mobilewellbeing.com	");
		addressq.add("	https://www.activity8.com/	");
		addressq.add("	http://www.pioneercardio.com	");
		addressq.add("	http://www.allstocks.com	");
		addressq.add("	https://glonu.com/	");
		addressq.add("	http://www.telepatheye.com	");
		addressq.add("	https://www.globaldatausa.com/	");
		addressq.add("	https://www.easybroker.com:443/	");
		addressq.add("	https://myptpal.westlondonpersonaltraining.co.uk/online-personal-training/	");
		addressq.add("	https://ubvita.com/	");
		addressq.add("	http://www.thred.in/	");
		addressq.add("	http://www.uvaid.com	");
		addressq.add("	http://www.market-teller.com	");
		addressq.add("	http://www.minomonsters.com/	");
		addressq.add("	http://www.tinyhabit.com/qiloz/xmmdz/	");
		addressq.add("	http://www.lucidknowledge.com	");
		addressq.add("	https://www.futureclaw.com/	");
		addressq.add("	https://visualizeroi.com/	");
		addressq.add("	https://leviathyn.com/	");
		addressq.add("	http://vy.io	");
		addressq.add("	http://www.crittercism.com	");
		addressq.add("	https://discoverfashions.com	");
		addressq.add("	http://www.getlocbox.com	");
		addressq.add("	https://www.xferral.com:443/	");
		addressq.add("	http://www.motivationscience.com	");
		addressq.add("	http://medkaz.com	");
		addressq.add("	http://www.cooltoes.com	");
		addressq.add("	http://www.joukuu.com	");
		addressq.add("	https://ziivaa.com/	");
		addressq.add("	https://www.seoengine.com/	");
		addressq.add("	https://www.healthrecoverypartners.com/	");
		addressq.add("	https://primarq.com/	");
		addressq.add("	http://www.jawo.co/ptjiz/	");
		addressq.add("	http://www.healthtechworks.com	");
		addressq.add("	https://www.tiphive.com/	");
		addressq.add("	http://splashscore.com	");
		addressq.add("	https://www.propable.com/	");
		addressq.add("	http://www.rawstream.com	");
		addressq.add("	https://www.drdoctor.co.uk/	");
		addressq.add("	http://www.revokom.com	");
		addressq.add("	https://www.securenok.com/	");
		addressq.add("	http://www.duedateplus.com	");
		addressq.add("	https://www.wealthfunnels.co	");
		addressq.add("	http://cream.hr	");
		addressq.add("	https://www.transparentchoice.com/	");
		addressq.add("	http://bluepandasystems.com/live/	");
		addressq.add("	https://www.energy.seikowave.com/	");
		addressq.add("	http://www.moneycms.com	");
		addressq.add("	https://www.amcimedia.com/	");
		addressq.add("	http://www.a1.io	");
		addressq.add("	https://www.abacusemedia.com/	");
		addressq.add("	http://www.abaqus.net	");
		addressq.add("	http://www.abcphp.com	");
		addressq.add("	http://www.abitalk.com	");
		addressq.add("	http://www.abk-soft.com/	");
		addressq.add("	https://abvio.com/	");
		addressq.add("	http://www.abzoo.com	");
		addressq.add("	http://www.terminalserviceslog.com	");
		addressq.add("	https://www.accountsportal.com/	");
		addressq.add("	https://www.accountz.com/	");
		addressq.add("	http://ww1.achatbatteries.com/	");
		addressq.add("	http://www.ackwired.com	");
		addressq.add("	http://www.acteva.com	");
		addressq.add("	http://www.actualonlinejobs.com	");
		addressq.add("	https://www.acuityrm.com/	");
		addressq.add("	https://addicted2success.com/	");
		addressq.add("	https://www.adhril.com/	");
		addressq.add("	http://www.adserve.com.au	");
		addressq.add("	https://awe365.com/	");
		addressq.add("	http://www.advertiseineurope.com/	");
		addressq.add("	https://adwordize.de/	");
		addressq.add("	https://www.aethratech.com/	");
		addressq.add("	http://www.benchmark7.com/	");
		addressq.add("	https://www.affilorama.com/	");
		addressq.add("	http://www.vongeorg.fil.ag/shop.php?cms_nav_id=372	");
		addressq.add("	http://www.aggrity.com	");
		addressq.add("	http://www.agileload.com	");
		addressq.add("	http://www.agile-1.com	");
		addressq.add("	https://www.agreedo.com/	");
		addressq.add("	https://www.aicache.com/	");
		addressq.add("	http://www.aisleten.com	");
		addressq.add("	https://www.aitoc.com/	");
		addressq.add("	http://www.alexanderinteractive.com	");
		addressq.add("	http://www.eyemags.com/em2/index.jsp	");
		addressq.add("	http://www.allrmc.com/	");
		addressq.add("	https://www.all-coupon-codes.com/	");
		addressq.add("	https://www.kerstpakkettenxl.nl/	");
		addressq.add("	https://www.allfreecoupons.com/	");
		addressq.add("	http://www.almost.at	");
		addressq.add("	http://www.altavistaaero.com	");
		addressq.add("	https://www.altaro.com/	");
		addressq.add("	http://www.alternion.com	");
		addressq.add("	https://www.acufinder.com	");
		addressq.add("	https://www.marketing.neustar/marketing-solutions	");
		addressq.add("	http://www.a-mass.de	");
		addressq.add("	http://kyku.tv/	");
		addressq.add("	https://www.ameliste.fr	");
		addressq.add("	http://amgonna.com/	");
		addressq.add("	https://www.amia-systems.com/	");
		addressq.add("	https://www.amnpathway.com/webinar/100k-webinar/	");
		addressq.add("	https://ampersandcommerce.com/	");
		addressq.add("	http://www.amystory.com	");
		addressq.add("	http://analiti.co	");
		addressq.add("	http://www.analyticsintelligence.com	");
		addressq.add("	https://www.anchanto.com/	");
		addressq.add("	https://www.andrisoft.com/	");
		addressq.add("	http://www.androidapplicationsprogrammer.com/cgi-sys/suspendedpage.cgi	");
		addressq.add("	https://www.android-enjoyed.com/	");
		addressq.add("	https://problemapc.com/	");
		addressq.add("	https://annonces-legales-faciles.com/	");
		addressq.add("	https://www.any-audio-converter.com/	");
		addressq.add("	http://www.ap16.com	");
		addressq.add("	http://apartmentadda.com	");
		addressq.add("	https://www.apimac.com/	");
		addressq.add("	http://www.apnacashback.com	");
		addressq.add("	http://apoloenergia.com.br/	");
		addressq.add("	https://appadia.com/	");
		addressq.add("	https://appcurate.com/	");
		addressq.add("	http://www.appleface.co/	");
		addressq.add("	https://www.applegate.co.uk/	");
		addressq.add("	https://www.applexsoft.com/	");
		addressq.add("	http://www.appmob.com	");
		addressq.add("	http://www.apprika.com	");
		addressq.add("	https://www.appsmarketing.mobi/	");
		addressq.add("	http://www.appspublisher.com	");
		addressq.add("	http://www.appstark.com	");
		addressq.add("	https://appstarting.com/	");
		addressq.add("	https://thefwa.com/	");
		addressq.add("	https://www.apptus.com	");
		addressq.add("	https://www.appversal.com/	");







		for (String companyUrl : addressq) {
			try {
				Elements elements = null;
				String address = null;
				try {
					Document document = getURLResponse(companyUrl);
					if (document != null) {
						// method 1
						Elements elements1 = Jsoup.parse(document.toString()).getElementsMatchingOwnText(pattern);
						for (Element element : elements1) {
							try {
								Matcher matcher = pattern.matcher(element.text());
								if (matcher.find()) {
									address = element.text();
								}
								if (!address.toLowerCase().contains("img height=")) {
									if (!address.toLowerCase().contains("name")) {
										if (!address.toLowerCase().startsWith("contact us")) {
											if (!address.toLowerCase().startsWith("+")) {
												if (!address.toLowerCase().contains("telephone:")) {
													if (!address.toLowerCase().contains("(toll free)")
															|| !address.toLowerCase().contains("toll free")) {
														boolean isNumeric = false;
														if (isNumeric == false) {
															String new_address = null;

															new_address = address.replace("All Rights Reserved", "")
																	.replace("Contact Us", "").replace("©", "").replace("|", "")
																	.replace("-", "").replace("/", "");
															;
															if (new_address != null) {
																//getCALocation(new_address.trim());
																System.out.println((new_address.trim()));
															}

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
						// second method
						Elements Productlink = document.getElementsByAttributeValueMatching("href", address_pattern);
						for (Element Productlinks : Productlink) {
							if (Productlinks != null) {
								if (Productlinks.hasAttr("href")) {
									String contactlink = Productlinks.attr("abs:href");
									if (!contactlink.contains("wp-content")) {
										Document document_new = getURLResponse(contactlink);
										if (document_new != null) {
											elements = Jsoup.parse(document_new.toString()).getElementsMatchingOwnText(pattern);
											for (Element element : elements) {
												try {
													Matcher matcher = pattern.matcher(element.text());
													if (matcher.find()) {
														address = element.text();
													}
													if (!address.toLowerCase().contains("img height=")) {
														if (!address.toLowerCase().contains("name")) {
															if (!address.toLowerCase().startsWith("contact us")) {
																if (!address.toLowerCase().startsWith("+")) {
																	if (!address.toLowerCase().contains("telephone:")) {
																		if (!address.toLowerCase().contains("(toll free)")
																				|| !address.toLowerCase()
																				.contains("toll free")) {
																			boolean isNumeric = false;
																			if (isNumeric == false) {
																				String new_address = null;
																				new_address = address
																						.replace("All Rights Reserved", "")
																						.replace("Contact Us", "")
																						.replace("©", "").replace("|", "")
																						.replace("-", "").replace("/", "");
																				if (new_address != null) {
																					//getCALocation(new_address.trim());
																					System.out.println((new_address.trim()));

																				}
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
									}
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void saveLocationCityStateZCountryZip(String address) {
		String pageContent="";
		try {
			// connection
			URL url = new URL(
					"http://api.addresslabs.com/v1/parsed-address?address=" + getLocation(address.trim()).replace(" ", "%20"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.connect();
			// taking data from json
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNext()) {
				pageContent = pageContent + sc.nextLine();
			}
			sc.close();
			JSONObject jsonObject = new JSONObject(pageContent);
			JSONObject deliveryObject = jsonObject.getJSONObject("delivery");
			System.out.println(deliveryObject.get("address_line")+"--"+jsonObject.get("city")+"--"+jsonObject.get("state")+"--"+jsonObject.get("zip"));
		
		} catch (Exception e) {
			//System.out.println("addresss format is different!!!!!!");
		}
	}
	
	//System.out.println(deliveryObject.get("address_line")+"--"+jsonObject.get("city")+"--"+jsonObject.get("state")+"--"+jsonObject.get("zip"));


	public static String getLocation(String addressText) {

		String location=null;
		String street = "\\d{1,6}[ ](?:[A-Za-z\\s0-9,\\.#]?)+[ ]?(?:Avenue|Ave|Lane|Roadz|Boulevard|Drive|Street|BLVD|Ave|Dr|Rd|Road|Blvd|AVE|Ln|St|Suite|th|Unit|Dr|floor|Floor|STE|Ste|Lyme|Court|level|NE|SE|Circle|Way|Cir|Redwood|Highway|Hwy|Route|East|West|Broadway|Mission|Tower|StreetRear|Place|Pike|Cynwyd|Pkwy|Expressway|Square|street|Room|Ct|Parkway|Pablo|Turnpike|Arques|Real|rd|BOX|Box|Building|BIN|So)\\,?\\.?[ ]?([\\#\\d{1,3}])?([A-Z]\\.)?([\\#[A-Z]])?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Z]?\\d{1,3}[A-Z])?([A-z]?\\d{1,3})?\\,?[ ]?(\\#?\\d{1,3})?(\\#?\\d{1,3}[A-Z])?\\,?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Za-z\\s]+)?[,]?[ ]?[\\.]?[ ]?\\d{1,5}";
		try {

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, street, 1000);
			if (matcher.find()) {
				location = matcher.group(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}
	
	public static String getCALocation(String addressText) {

		String location=null;
		String street = "\\d{1,6}[ ](?:[A-Za-z\\s0-9,\\.#]?)+[ ]?(?:Avenue|Ave|Lane|Roadz|Boulevard|Drive|Street|BLVD|Ave|Dr|Rd|Road|Blvd|AVE|Ln|St|Suite|th|Unit|Dr|floor|Floor|STE|Ste|Lyme|Court|level|NE|SE|Circle|Way|Cir|Redwood|Highway|Hwy|Route|East|West|Broadway|Mission|Tower|StreetRear|Place|Pike|Cynwyd|Pkwy|Expressway|Square|street|Room|Ct|Parkway|Pablo|Turnpike|Arques|Real|rd|BOX|Box|Building|BIN|So)\\,?\\.?[ ]?([\\#\\d{1,3}])?([A-Z]\\.)?([\\#[A-Z]])?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Z]?\\d{1,3}[A-Z])?([A-z]?\\d{1,3})?\\,?[ ]?(\\#?\\d{1,3})?(\\#?\\d{1,3}[A-Z])?\\,?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Za-z\\s]+)?[,]?[ ]?[\\.]?[ ]?(?:[ABCEGHJKLMNPRSTVXY]\\d[ABCEGHJKLMNPRSTVWXYZ][ ]?\\d[ABCEGHJKLMNPRSTVWXYZ]\\d)";
		try {

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, street, 1000);
			if (matcher.find()) {
				location = matcher.group(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}
	public static Document getURLResponse(String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).followRedirects(true).userAgent(PASEConstants.USER_AGENT).ignoreHttpErrors(true).timeout(1000).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

	public static Integer countChar(String string) {

		int count = 0;

		// Counts each character except space
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ' ')
				count++;
		}
		return count;
	}

	public static int wordcount(String string) {
		int count = 0;

		char ch[] = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			ch[i] = string.charAt(i);
			if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
				count++;
		}
		return count;
	}
}
