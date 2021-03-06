


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractOnlyLIinkedInLInks {

	public static void main(String[] args)  {
		int count=0;
		List<String> urls=new ArrayList<String>();
		
		urls.add("http://www.bikramyogalangley.ca");
		urls.add("https://elifestyle.ca");
		urls.add("https://www.plensat.com/");
		urls.add("https://ericaross.com/");
		urls.add("http://www.nomadinteractif.com");
		urls.add("http://www.mcelwainandcompany.com");
		urls.add("https://www.panomtech.com/");
		urls.add("http://digitalseahorse.com");
		urls.add("http://www.studio-zoetrope.com");
		urls.add("https://www.lesleyoverall.com/");
		urls.add("http://www.bestcolorvideo.com");
		urls.add("http://www.mediadesignservices.com");
		urls.add("http://www.sprout.ca");
		urls.add("http://www.finleycommunication.com");
		urls.add("https://www.allerpassmd.com/	");
		urls.add("http://zzq-corp.com/	");
		urls.add("http://www.sicollegeplanners.com	");
		urls.add("http://www.appic.gozha.net/	");
		urls.add("https://www.amanimedspa.com/	");
		urls.add("https://www.gennovacap.com/	");
		urls.add("https://www.wmakarate.com/	");
		urls.add("http://www.sebmenard.com	");
		urls.add("	http://www.b-line.ca	");
		urls.add("	http://thecreativepub.com	");
		urls.add("	http://www.optimaldesignstudio.com	");
		urls.add("	http://www.beyondvitality.com	");
		urls.add("	http://www.intergoldex.com	");
		urls.add("	https://www.meeksmediagroup.com/	");
		urls.add("	https://www.cyberxlink.com/	");
		urls.add("	https://www.8west.ca/	");
		urls.add("	https://www.oscehome.com/	");
		urls.add("	http://www.leopharmarx.com/	");
		urls.add("	http://www.humbersys.com	");
		urls.add("	https://www.nassauguidance.com/	");
		urls.add("	http://www.organizedhavens.com	");
		urls.add("	https://tech2020solutions.com/	");
		urls.add("	https://www.accelweb.ca/	");
		urls.add("	http://www.mouzlo.com/	");
		urls.add("	https://www.dermmedica.ca/	");
		urls.add("	https://www.ortholaval.com/	");
		urls.add("	http://www.tylergjonesmd.com	");
		urls.add("	http://www.mrgadvertising.com	");
		urls.add("	http://www.kbiapps.com	");
		urls.add("	https://needatechguy.com/	");
		urls.add("	https://simondelasalle.com/	");
		urls.add("	http://www.keyvaletinc.com	");
		urls.add("	http://www.njflyingflyers.com	");
		urls.add("	http://www.addflip.com	");
		urls.add("	http://www.careersbiotech.com	");
		urls.add("	http://www.nikanaturalhealth.com/	");
		urls.add("	http://directoryready.com/	");
		urls.add("	https://resultsplus.com/	");
		urls.add("	http://hamptonhealthltd.com	");
		urls.add("	https://www.symboles.ca/	");
		urls.add("	http://calindaniel.com	");
		urls.add("	http://www.drmarion.com	");
		urls.add("	https://www.consult-pro.com/	");
		urls.add("	https://justgotdiagnosed.com/	");
		urls.add("	http://www.counselingtoyou.com	");
		urls.add("	http://www.mastibazaar.com	");
		urls.add("	https://www.sgm-canada.com/	");
		urls.add("	http://www.drbrowns.com/	");
		urls.add("	http://www.californeon.ca	");
		urls.add("	http://www.dawgfm.com	");
		urls.add("	http://www.loudercpa.com	");
		urls.add("	https://www.touey.com/	");
		urls.add("	http://www.schmidtcpagroup.com	");
		urls.add("	http://www.taxshack.com	");
		urls.add("	http://www.ecoleshakespeare.com	");
		urls.add("	http://elanenergetics.com/	");
		urls.add("	https://www.jiakaobaodian.com/	");
		urls.add("	https://www.andcompany.com/	");
		urls.add("	https://dotdecimal.com/	");
		urls.add("	https://www.hca.hitachi-cable.com/products/medical/medical-solutions.php	");
		urls.add("	http://www.mfcstudios.com	");
		urls.add("	https://www.echopromotions.ca/	");
		urls.add("	http://www.brewlife.com	");
		urls.add("	https://www.mdstaff.com/	");
		urls.add("	http://servarusrm.com/	");
		urls.add("	http://www.webmarketingassociation.org/wma/	");
		urls.add("	http://www.cloudlogistix.com/	");
		urls.add("	http://www.pmasolutions.com	");
		urls.add("	https://www.enterpriseirregulars.com/	");
		urls.add("	http://www.codingstaff.com	");
		urls.add("	http://www.womensleadershipexchange.com	");
		urls.add("	https://www.oriso.com/	");
		urls.add("	https://constantlink.com/	");
		urls.add("	http://www.jobcred.com	");
		urls.add("	http://chicmeetsgeek.com/site/	");
		urls.add("	https://www.lunawebs.com/	");
		urls.add("	https://www.engineeroutsourcing.com/	");
		urls.add("	http://www.billingworld.com/	");
		urls.add("	http://www.ufathom.com	");
		urls.add("	https://www.zedsuite.com/	");
		urls.add("	http://www.conversiondoubler.com	");
		urls.add("	http://www.exod-gc.com	");
		urls.add("	https://isi-mtl.com//	");
		urls.add("	http://www.biditech.com	");
		urls.add("	https://youragent.linkbidagency.com/	");
		urls.add("	http://www.leasespacenow.ca	");
		urls.add("	http://www.2minuteexplainer.com	");
		urls.add("	http://httc.me	");
		urls.add("	http://patienttrac.com	");
		urls.add("	http://www.cloudmailin.com	");
		urls.add("	https://www.coveryourhair.com/	");
		urls.add("	https://www.yoush.com/	");
		urls.add("	http://www.grafikux.com	");
		urls.add("	http://1800mylawyer.com	");
		urls.add("	http://www.stefx.com/	");
		urls.add("	https://www.domaination.com/lander/pinkcubicle.com?domain=pinkcubicle.com&utm_source=pinkcubicle.com&utm_medium=click&utm_campaign=inlander&traffic_id=inlander&traffic_type=tdfs&redirect=ono-redirect	");
		urls.add("	http://www.theboombus.com	");
		urls.add("	https://www.hugedomains.com/domain_profile.cfm?d=milleverba&e=com	");
		urls.add("	http://www.xcartdevelopment.com	");
		urls.add("	http://www.thinkingroom.com/	");
		urls.add("	https://fivepointmedia.com/	");
		urls.add("	http://www.restoactive.com	");
		urls.add("	https://bawtreesoftware.com/	");
		urls.add("	http://www.email2.com	");
		urls.add("	https://www.i2bglobal.com/	");
		urls.add("	https://www.jukedocs.com/	");
		urls.add("	https://www.3idatascraping.com/	");
		urls.add("	http://www.sandoaks.com	");
		urls.add("	http://www.realsearchppc.com	");
		urls.add("	http://www.goklg.com	");
		urls.add("	http://www.klsmartinnorthamerica.com	");
		urls.add("	http://www.odegardwebdezine.com	");
		urls.add("	http://www.pakragames.com	");
		urls.add("	http://www.rotenbergmeril.com	");
		urls.add("	http://www.bodypure.com	");
		urls.add("	http://www.enspirix.com	");
		urls.add("	http://crm.paretoplatform.com	");
		urls.add("	http://olympiany.com	");
		urls.add("	http://www.onyxstock.com	");
		urls.add("	http://www.santorinimedia.com	");
		urls.add("	http://www.codycorpe.com	");
		urls.add("	http://www.itactility.com/	");
		urls.add("	http://www.comptutoring.com	");
		urls.add("	http://www.roguedevtp.com	");
		urls.add("	http://www.mavericks7.com	");
		urls.add("	http://www.digitalbiz4u.com	");
		urls.add("	http://www.goweego.com	");
		urls.add("	http://www.golf4gift.com	");
		urls.add("	http://www.trilliumhearing.ca	");
		urls.add("	https://www.hugedomains.com/domain_profile.cfm?d=1stopesolution&e=com	");
		urls.add("	http://enliken.com	");
		urls.add("	http://flippo-interactive.com	");
		urls.add("	http://www.myxraybag.com	");
		urls.add("	http://www.independenthealing.com	");
		urls.add("	http://www.medstatfacts.com	");
		urls.add("	http://www.47scrubs.com	");
		urls.add("	http://www.douglasleech.com	");
		urls.add("	https://www.afternic.com/forsale/triadlab.com?utm_source=tdfs_daslnc&utm_medium=daslnc&utm_campaign=tdfs_daslnc&traffic_type=tdfs_daslnc&traffic_id=daslnc&	");
		urls.add("	http://www.dataflow-labs.com	");
		urls.add("	http://www.inexian.com	");
		urls.add("	http://thecityswig.com	");
		urls.add("	http://www.crawfordcommunitymgmt.com	");
		urls.add("	https://www.maxwellrand.com/	");
		urls.add("	http://www.christidball.com	");
		urls.add("	http://arlingtonwealth.com	");
		urls.add("	http://www.genysisfinancial.com	");
		urls.add("	https://www.squadhelp.com/name/vowto	");
		urls.add("	http://www.gistrainingsource.com	");
		urls.add("	http://www.prion-usa.com	");
		urls.add("	https://www.hugedomains.com/domain_profile.cfm?d=ctkanata&e=com	");
		urls.add("	http://www.beeonthelist.com	");
		urls.add("	http://nssconnect.com	");
		urls.add("	https://www.informed.co/	");
		urls.add("	https://www.advance-medical.net/	");
		urls.add("	https://www.arazygroup.com/	");
		urls.add("	https://www.bermanhopkins.com/	");
		urls.add("	https://consoltech.com/	");
		urls.add("	https://www.nad.ca/	");
		urls.add("	http://www.fitafter50.ca/	");
		urls.add("	http://www.isiconsulting.com	");
		urls.add("	https://www.cesium.com	");
		urls.add("	https://marinersoftware.com/	");
		urls.add("	https://mwcad.com/	");
		urls.add("	https://netfore.com/	");
		urls.add("	https://outreachmedia.ca/	");
		urls.add("	https://www.puginteractive.com	");
		urls.add("	https://www.relatestrategy.com/	");
		urls.add("	https://www.sigma-software.ca/	");
		urls.add("	https://www.snapfinancial.com/	");
		urls.add("	http://www.softlanding.ca	");
		urls.add("	https://www.vpfgroup.com/team/grandville/	");
		urls.add("	http://www.patriotmobileimaging.com/	");
		urls.add("	https://www.acularo.com/	");
		urls.add("	https://www.postrehab.com/	");
		urls.add("	https://periferiaitgroup.com/	");
		urls.add("	https://www.nologin.es/en/	");
		urls.add("	http://www.akw-medicare.com/	");
		urls.add("	https://direxyon.com/fr/modex	");
		urls.add("	https://www.stardust-testing.com/	");
		urls.add("	http://www.gestion-pme.com	");
		urls.add("	http://www.4ways.com	");
		urls.add("	https://www.agicent.com/	");
		urls.add("	https://www.alvaka.net/	");
		urls.add("	https://www.cfobridge.com/	");
		urls.add("	https://www.churchgatepartners.com/	");
		urls.add("	https://www.cusimanopc.com/	");
		urls.add("	http://www.dgbsinc.com	");
		urls.add("	http://www.fulcrumlogic.com	");
		urls.add("	https://www.armortext.co:443/	");
		urls.add("	https://infocareit.com/	");
		urls.add("	https://www.larenon.com/	");
		urls.add("	https://www.leewayhertz.com/	");
		urls.add("	http://www.manusbio.com	");
		urls.add("	https://www.metizsoft.com/	");
		urls.add("	www.moolchandhealthcare.com	");
		urls.add("	https://www.orionesolutions.com/	");
		urls.add("	http://www.realtech-vr.com/ironfistboxing	");
		urls.add("	https://www.technolabssoftware.com/	");
		urls.add("	https://www.ssidecisions.com/	");
		urls.add("	http://www.omnisourcing.net	");
		urls.add("	http://www.authentify.com	");
		urls.add("	https://savillecpa.com/	");
		urls.add("	http://www.ijoinsuccess.com	");
		urls.add("	https://www.perigonwealth.com	");
		urls.add("	https://swiftsocial.com/	");
		urls.add("	https://www.defoorservices.com/	");
		urls.add("	https://www.bacogroup.com/	");
		urls.add("	https://reference.ca	");
		urls.add("	http://www.treassure.com	");
		urls.add("	https://www.cmra.com/	");
		urls.add("	https://physiotherapieuniverselle.com/	");
		urls.add("	https://www.telanet.com/	");
		urls.add("	https://www.simplectms.com/	");
		urls.add("	https://www.techgroup.net/	");
		urls.add("	https://www.bkc-cpa.com/	");
		urls.add("	https://www.ctcmycfo.com/	");
		urls.add("	http://www.mfbcpa.com	");
		urls.add("	http://minesense.com/	");
		urls.add("	https://www.asp.md/	");
		urls.add("	https://www.ulehssustainability.com/	");
		urls.add("	https://www.cr360.com/	");
		urls.add("	http://www.clarity.ca	");
		urls.add("	https://www.cyclonedesign.ca/	");
		urls.add("	https://www.mysoftwaresolutions.com/	");
		urls.add("	https://www.staaralert.com/	");
		urls.add("	https://www.healthfairsdirect.com/	");
		urls.add("	http://www.staffciampino.com	");
		urls.add("	https://www.fahouryink.com/	");
		urls.add("	http://www.insurewealth.ca	");
		urls.add("	https://www.axtrading.com/	");
		urls.add("	https://www.elitepromomarketing.com/	");
		urls.add("	https://www.rightathome.net/north-central-west-virginia	");
		urls.add("	https://www.advantax.com/	");
		urls.add("	https://www.tritoncomputercorp.com/	");
		urls.add("	http://www.employerwellnesssolutions.com/	");
		urls.add("	https://www.ronwear.com/	");
		urls.add("	http://www.gem-up.com	");
		urls.add("	http://www.encoreinteractive.ca	");
		urls.add("	https://www.specialneedsplanning.com/	");
		urls.add("	https://www.crearewebsolutions.com/	");
		urls.add("	https://www.summitweb.com/	");
		urls.add("	https://wealthdesignllc.com/	");
		urls.add("	https://way-point.net/	");
		urls.add("	https://www.npnow.com/	");
		urls.add("	https://linkpoint.ca/	");
		urls.add("	https://www.datumtechnologies.com	");
		urls.add("	https://www.groupecfoconseil.com/	");
		urls.add("	https://www.latitude365.com/	");
		urls.add("	https://www.lancecpa.com/	");
		urls.add("	http://www.childrensheartcenter.com	");
		urls.add("	http://www.tenzing.com?utm_source=rf0015	");
		urls.add("	https://ca.nxgen.com/	");
		urls.add("	https://mannassi.com/	");
		urls.add("	https://www.pcesolutions.ca/	");
		urls.add("	https://www.plogg.ca	");
		urls.add("	https://www.atlanticamericanpartners.com/	");
		urls.add("	http://www.nybkw.com	");
		urls.add("	https://netaccess.ca/	");
		urls.add("	https://netaccess.ca/	");
		urls.add("	https://www.askida.com/	");
		urls.add("	http://www.prin-tech.com	");
		urls.add("	https://www.purelink.ca/en/index.en.php	");
		urls.add("	https://www.clevelandgroup.net/	");
		urls.add("	http://www.patientadvocateforyou.com	");
		urls.add("	https://www.smilesinternational.com/	");
		urls.add("	https://www.proveres.com/	");
		urls.add("	https://www.fusioninvest.com/	");
		urls.add("	https://www.connectmedical.biz/	");
		urls.add("	http://www.bna-rep.com	");
		urls.add("	https://www.mothernode.com/	");
		urls.add("	https://cloudxchange.io/	");
		urls.add("	http://www.simarn.com	");
		urls.add("	https://factor1.com/	");
		urls.add("	https://www.alpinesoftit.com/	");
		urls.add("	https://coppertree.com/	");
		urls.add("	http://www.radiusfinancial.ca	");
		urls.add("	https://borensteingroup.com/	");
		urls.add("	https://www.getwealthylife.com	");
		urls.add("	https://www.ndfya.com/	");
		urls.add("	http://www.itrackgps.com	");
		urls.add("	https://www.ergcouncil.com/	");
		urls.add("	https://www.webpal.net/home	");
		urls.add("	http://sjordanassociates.com/	");
		urls.add("	https://www.usa.philips.com/healthcare/services/population-health-management/patient-engagement/remote-patient-monitoring	");
		urls.add("	http://www.hrlab.com	");
		urls.add("	http://www.talkincloud.com/	");
		urls.add("	https://www.empirecom.on.ca/	");
		urls.add("	https://www.3percentmovement.com	");
		urls.add("	https://greenbusinessowner.com/	");
		urls.add("	https://www.cambridgewhoswho.com/	");
		urls.add("	https://www.xtalks.com/	");
		urls.add("	http://www.antvibes.com	");
		urls.add("	http://www.santium.com	");
		urls.add("	http://spinningcook.com	");
		urls.add("	http://twittley.com	");
		urls.add("	https://www.beaucoupplus.com/	");
		urls.add("	http://www.avalontraining.com	");
		urls.add("	https://www.wcdental.ca/	");
		urls.add("	https://www.fmconsulting.net/	");
		urls.add("	https://influence.fm/	");
		urls.add("	https://www.1800notify.com	");
		urls.add("	https://www.dsiglobal.com/	");
		urls.add("	https://swctn.com/	");
		urls.add("	https://www.coriell.com/	");
		urls.add("	http://www.divert-x.com	");
		urls.add("	https://www.gunify.com/site/	");
		urls.add("	https://www3.viiad.com/home	");
		urls.add("	https://patents.com/	");
		urls.add("	http://westernstatesbiopharm.com	");
		urls.add("	http://alphamaleinfo.com/	");
		urls.add("	https://www.agendacloud.com	");
		urls.add("	https://www.elitehive.com	");
		urls.add("	http://www.favy.com	");
		urls.add("	http://www.rankexplosion.com	");
		urls.add("	http://www.weddingstub.com	");
		urls.add("	http://www.assistiveapps.com	");
		urls.add("	http://www.chartburst.com	");
		urls.add("	https://altbio.com/	");
		urls.add("	https://modshopr.com/	");
		urls.add("	https://shawwebsitedesign.jimdofree.com/	");
		urls.add("	https://www.corvelle.com/	");
		urls.add("	https://www.adventuresportsnetwork.com:443/	");
		urls.add("	http://www.zenthea.com	");
		urls.add("	https://www.swipechart.com	");
		urls.add("	https://www.welated.com	");
		urls.add("	https://www.insurancelibrary.com/	");
		urls.add("	https://www.getstoried.com/	");
		urls.add("	http://www.memberrx.com	");
		urls.add("	http://www.guidemia.com	");
		urls.add("	https://www.signsus.com/	");
		urls.add("	http://www.spitfireinteractive.com	");
		urls.add("	http://soc-sec.net	");
		urls.add("	https://www.radiancedentalhygiene.ca/	");
		urls.add("	http://www.two-potato.com	");
		urls.add("	https://www.websforgood.com/	");
		urls.add("	https://datamicrotn.com/	");
		urls.add("	http://standardmediacompany.com	");
		urls.add("	http://marchini@baypsych.com	");
		urls.add("	http://www.reigniteonline.com	");
		urls.add("	http://www.spa-venus.com	");
		urls.add("	http://www.touchstonemcg.com	");
		urls.add("	http://www.nutri-verse.com/	");
		urls.add("	http://www.leannekroll.com	");
		urls.add("	http://sciostream.com	");
		urls.add("	https://www.em-space.com/	");
		urls.add("	http://www.cochraneawards.com	");
		urls.add("	http://www.bellaverde.net	");
		urls.add("	http://www.huardconsultant.com	");
		urls.add("	https://inbounddesign.com/	");
		urls.add("	http://www.dodgeink.com	");
		urls.add("	http://www.keys2engage.com	");
		urls.add("	http://www.vizib.ca	");
		urls.add("	https://www.knowwwhow.com/	");
		urls.add("	https://www.harthearing.com/	");
		urls.add("	https://www.sniderchiropractic.com/	");
		urls.add("	http://www.audaster.com/	");
		urls.add("	http://www.lawebmestrerie.net/	");
		urls.add("	https://www.topoftheburg.com/	");
		urls.add("	https://articulatecc.com/	");
		urls.add("	https://www.rebrand.ca/	");
		urls.add("	http://www.canfocus.com	");
		urls.add("	https://www.galaxy61.com/	");
		urls.add("	http://www.evolvemedsys.com	");
		urls.add("	https://dan.com/buy-domain/viewnine.com?redirected=true&tld=com	");
		urls.add("	https://www.12stepmatch.com/	");
		urls.add("	http://www.4gwirelessjobs.com	");
		urls.add("	http://www.buybackworld.com	");
		urls.add("	http://caaspc.com	");
		urls.add("	http://www.drial.com.mx	");
		urls.add("	http://www.gobiojobs.com	");
		urls.add("	http://www.halfpricesandiego.com	");
		urls.add("	http://www.healthproducts2.com	");
		urls.add("	http://www.ifuturz.com	");
		urls.add("	http://www.ilikewebsites.com.co/	");
		urls.add("	http://www.healthtechnolgy.com/cgi-sys/suspendedpage.cgi	");
		urls.add("	http://www.solarisd.com/	");
		urls.add("	http://axeium.com/	");
		urls.add("	http://www.generalblood.com	");
		urls.add("	http://www.birdpr.com/	");
		urls.add("	http://www.123win.com	");
		urls.add("	http://www.zircoo.com/	");
		urls.add("	http://www.newtonsocial.com	");
		urls.add("	https://www.webmontonmedia.com/default.aspx	");
		urls.add("	http://www.mehi-tech.com	");
		urls.add("	https://www.biologicmodels.com/	");
		urls.add("	https://www.l-e.com/lewebsite	");
		urls.add("	http://www.apptimyze.com	");
		urls.add("	http://koolstreet.com/	");
		urls.add("	http://www.marketingbydeepak.com	");
		urls.add("	http://www.pure-moxie.com	");
		urls.add("	http://www.thisismyweek.com	");
		urls.add("	http://www.sixdegreesrrc.com	");
		urls.add("	http://www.searchmonkeymedia.com	");
		urls.add("	http://www.stonehousemeetings.com	");
		urls.add("	http://www.tailored-media.com	");
		urls.add("	http://www.my-e-assistant.com	");
		urls.add("	http://www.emailserving.com	");
		urls.add("	https://www.arrivait.com/	");
		urls.add("	https://joesaver.com/	");
		urls.add("	https://www.hugedomains.com/domain_profile.cfm?d=telescopemarketing&e=com	");
		urls.add("	http://www.pepconcept.com	");
		urls.add("	http://www.yestel.ca	");
		urls.add("	http://discoveryorthopartners.com/	");
		urls.add("	http://www.tsswoundcare.com	");
		urls.add("	https://paraklesiscounselling.com/	");
		urls.add("	http://www.ballroomdancingtoronto.com	");
		urls.add("	http://www.travelwiggle.com	");
		urls.add("	https://www.trottergo.com/	");
		urls.add("	http://homevisor.com	");
		urls.add("	http://www.integritydefender.com	");
		urls.add("	https://www.domainmarket.com/buynow/iclearstudios.com	");
		urls.add("	https://appcurate.com/	");
		urls.add("	http://www.paxxon.com	");
		urls.add("	http://www.scriptgurus.com	");
		urls.add("	http://www.strategicmediapartner.com	");
		urls.add("	http://roi-direct.com/	");
		urls.add("	https://www.alyr.com/	");
		urls.add("	http://thestylester.com/	");
		urls.add("	https://www.cancerpreventiondaily.com/	");
		urls.add("	http://lexpubli.ca/	");
		Iterator iterator= urls.iterator();
		while (iterator.hasNext()) {
			String urlLink= (String) iterator.next();
			count++;
			try {
				Document document=Jsoup.connect(urlLink).get();	
				//System.out.println(urlLink);
	            //Linkedin
				//String linkedinPattern = "(http|https){0,1}:{0,1}//(www.)?(linkedin.com/)[A-Za-z0-9-_./?&-=]{0,100}";
				String linkedinPattern="(http|https){0,1}:{0,1}//(www.)?(linkedin.com/company)+[A-Za-z0-9-_./?&-=]{0,100}";
				Elements linkedInLink= document.getElementsByAttributeValueMatching("href", linkedinPattern);
				if(!linkedInLink.attr("href").isEmpty())
				{
					if(linkedInLink.attr("href").matches(linkedinPattern))
					{
					System.out.println(linkedInLink.attr("href"));
					}else
					{
						System.out.println("It does not have LinkedIn Link in this page");
					}
					
				}else
					{
						System.out.println("It does not have LinkedIn Link in this page");
					}
				}
			
			catch (Exception e) {
				System.out.println("Website is not Working");
				;
			}
		}
	}
}


