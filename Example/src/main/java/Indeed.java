import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Indeed {
	public static void main(String[] args){

		List<String> urls=new ArrayList<String>();

		urls.add("	http://www.indeed.com/viewjob?jk=cd50f23e0f8001e4&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOjrTcMI8rjetdLL_mP2xnmmVaIziPKwsWFPNaV41TMn-XjYal6K0xNoc01xb544M8ekHKiwCpmneameK-EYRAi6gIUsyJs4IRptRqGe57AKQ&indpubnum=5427925295141725&atk=1e1rjjrnlbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=b4309370827a2f20&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOjrTcMI8rjetdLL_mP2xnmmVaIziPKwsWFPNaV41TMn-XjYal6K0xNoc01xb544M8ekHKiwCpmneameK-EYRAi6gIUsyJs4IRptRqGe57AKQ&indpubnum=5427925295141725&atk=1e1rjjrnlbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=2275cbc8f07ffbc3&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOjrTcMI8rjetdLL_mP2xnmmVaIziPKwsWFPNaV41TMn-XjYal6K0xNoc01xb544M8ekHKiwCpmneameK-EYRAi6gIUsyJs4IRptRqGe57AKQ&indpubnum=5427925295141725&atk=1e1rjjrnlbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=40ebbcb47a901326&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOjrTcMI8rjetdLL_mP2xnmmVaIziPKwsWFPNaV41TMn-XjYal6K0xNoc01xb544M8ekHKiwCpmneameK-EYRAi6gIUsyJs4IRptRqGe57AKQ&indpubnum=5427925295141725&atk=1e1rjjrnlbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=eeef966802868509&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyMXl50csOp61EPPv1FYOT6aUsdWtCi1VKYjxAk5oKdfwo3XamscKQ7-SyDp9rGIHTeabvQwh9CaEaJiu1Y7VVc9gwX4RPCIMzv6vy0IGPvzWQ&indpubnum=5427925295141725&atk=1e1rjjt6gf22f801																			");
		urls.add("	http://www.indeed.com/pagead/clk?mo=r&ad=-6NYlbfkN0AyMV8WguZTeShE0iuGuqnLfVPONAxmKO7gHpNepFgGhAdwRm8izpdKzb2t72Bd_LjonkXpwLsi-2eLtOXYWDmmlXQ2II23mB2lN_sgnFekBaUFMM_Ask2RqGFJuTxbKTIoWj8DHJvaq_XV4iMZxynXUc2GAWBuoh3vQg5FORXVljZ-avZapeNPt4AIlvUCUUh8VIsWV8w-6XR4_HdlgD75zGFBvL7dqzx1M0-w-Kd-nQRn1rBOpMDoeodjFAMBXxoAP3_b6xa90SJKavkmwi-qRyevvfyB-_4g0TkdA8BqvS8UL7qjxD4V-TjQNB0_HFRtZWxbrPzZbInw5_P5SIHos1z908ZaJztNvcbCSRvqw4j610XKXl_htzlLe60US-16jsWJqp_kiP9e5owCPy3KunRpsmmuetoxLhsUr7DFF1VL_j-RwV5GrLZ-jwudk1JNjiC_FPzaebMv6NwptPXxpfdFqWYadjlOhiFbI7CXCdN4lzO_wXlI5gwbsJMJEW7tBnki1HGGrRdbmZY35Is0fr8GDxXidKiFHsyiLf-cBw==&p=0&rjs=1&atk=1e1rjjuc9f27i801&utm_source=publisher&utm_medium=sponsored_listings&utm_campaign=sia																			");
		urls.add("	http://www.indeed.com/pagead/clk?mo=r&ad=-6NYlbfkN0AtPu15fcnU7wqICzoT3ZwAHq_H4PCbyrnElw_HBP2wS2NauCW2PTYkdMwgCJUSfaybPG1X0FZ076rk-YFglHTpSucke50LBiPdSt155vm_EYzR9MPvHAHlyqsAcBshMSkBq6rdODArzxHeIaXV8ks3l4ABe8KncJbTRLElXNxDWZ_PFRIk3yeFGNoKsD_2Ty67Iia7fXRgVUAA9m96VnBFkaKcQx9UKcHM13EeuWJh3A_mGX3M2iZbT3SEtqUt9cKLzbbt-WozpIH4irYTABoe_9t10mjzDe789tJssQ2H21NaptUQWzYXImDWrFtPhg0E8XyzHmY_n2S31ybbD_4_17ecQX2dYEV5UzY133NYy_72-hwWiQqoH3f3LAfwyoCVMSy2-lVRfzMl9M0nGIkiuDj2tWDaABPZhO65Zn-468Mzi7TI8Bcv3aecZ_R1CFxDrPckwheADzeExZ6dMc9eZHRP0WpeAXDj2d6gt6t5ljMN6Busg3FBtLWGcFCjFUngmAhQWXebTWQuxnrcWN-N&p=0&rjs=1&atk=1e1rjjv58f2vf800&utm_source=publisher&utm_medium=sponsored_listings&utm_campaign=sia																			");
		urls.add("	http://www.indeed.com/pagead/clk?mo=r&ad=-6NYlbfkN0AtPu15fcnU7wqICzoT3ZwAHq_H4PCbyrnElw_HBP2wS1qrdc10O2pnikaCv3yrxTVSklvxMv6McWhpWVoHCeQaNs4O3yiEOZi4QlZRjGEEpcJExuIfwg4SVvN-OtJ8S-J28zD9UbogFtW9sImHX2DltATRKSEgka7ehZEAKxZFKRWpyvVQ2s2YLiAzHIT0sZ9HiwLxcyNUMka6m60pv-uGsR0du1Qio5-ee3HEwmm_cQxeWqOgYA093hXyP57ULkvYWOjFByMiArKLrHY6sQVq7dndq3NGGoljjt_mOq315cnYJn7IrNQTz10AnLyXdUIq1cXOEVgl8HjwAkaWVhI7VMb_P6FMHWsGyceSboKAPBc7A_bBdPYZF05KxNzyJThnnWDrhNm9-Ur-JnTPEOOOoy6JSGS-vGlS5mpCWrATCYUoddAPFT7rPs7gv75U4N2mjXpYuz4E35LaixSu6VQFsziq4gm8i2j9UKdSqn43NmR8ab45aWJzWXVBzWt4bknfWLz0RwsagtFYnuX97Pbd57XU_R8hED4=&p=2&rjs=1&atk=1e1rjjv58f2vf800&utm_source=publisher&utm_medium=sponsored_listings&utm_campaign=sia																			");
		urls.add("	http://www.indeed.com/pagead/clk?mo=r&ad=-6NYlbfkN0AtPu15fcnU7wqICzoT3ZwAHq_H4PCbyrnElw_HBP2wSyTpDiC6IXcwNt2y2DiHwTFmSP-6srNq-8q_7x8dUzBtXNpeVrg1J__7B3yH0kP6k_Hmk2v4xcpbg_ZeaTOEgWaFq99NxFyuLuDd897xaCa6Bl2RaW415WHkdS7N1tGJ6mWhw_7K-RYiUJzwlswHUG_yHbIYalhR73SMdpLIQNJyfGXaKnZ_f7DT6MUyi_zFBHvf3-SD5z4H-vYjg4QNovT9tC9orXZPlApCabGmHmYIwvp4aECHsdo623dpEG0gatjQw4yzNznWU6dGIpotZZ1DWkS4fPOsersDI9ds_JwO59jBu0QqoPsxXQJaK6YlBvHJO9PWVPqHPd61LxUPumtD9aEi0WRbVpFuY3ExDWGtRI0pn2m65tSh3dnpLzrhBUivad94PvyPsCJ_kWG_Cu9REq2KF94J16ufrk6kfCYZjFnP1tjT1wiKd5FjuffEgc7g6S2b00xhDJcADCAHqayulJL45eDobWFVD5COKkq6R3S2X_eE1wbe6StfzmtimIrbjs3f38Zt&p=3&rjs=1&atk=1e1rjjv58f2vf800&utm_source=publisher&utm_medium=sponsored_listings&utm_campaign=sia																			");
		urls.add("	http://www.indeed.com/pagead/clk?mo=r&ad=-6NYlbfkN0AtPu15fcnU7wqICzoT3ZwAHq_H4PCbyrnElw_HBP2wS51TeXXTIPqTbiXNTq1AUH_6YhBEJhrHOfQd4GM98JT7pbcD_c1NODMCk3MuHXAi2i6_I0-n10oUxJqe2ieQ_VqP0lpr3cHKy9bazDSvTXOscw6-y0nSmy-zZ5qsO7mSwzyT2qQE-zhKibFHALkxmhv1gCpcBhlowOFsJDIu3PJQlnwsxaopGeG6Yw5lJ-q9XEmK1QTh4eLsA5IkebR1DQi5LTXBumuiX1gckCvjxZ3ONyBZPVxK59FSTwH8uBBYK4WKV_4AwSDsc0tUgVw891hjnu6VwQGyI9uHA80jmpO2r-z5gaZxvlF0F1X0FhN8dgEBfie8iEuLUNWKKTVTSiTBIpEAIVC1qeMDVgVMDoC48HOcY156WwK3RLUWzqU1Tv2U_O98-RceZ_oWNkVF82HcZQysJMVpbytwoRkeOIYgmRS_uomJFOMDb4o4OSVfPm7c7v9JIbkX1k39OXHduD8RdgN5j1Gr6bshjUm4kKiI&p=4&rjs=1&atk=1e1rjjv58f2vf800&utm_source=publisher&utm_medium=sponsored_listings&utm_campaign=sia																			");
		urls.add("	http://www.indeed.com/viewjob?jk=c5faeedf5389cb00&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=ba046fbe28f8b5ce&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=067d2734c9fefdd7&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=696a74e183b24836&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=da83991fd78018b7&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=a15e7a178051917d&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=8aff1cbd7c731207&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=9633767eedf375b0&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=98a52d95b1c551c7&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=9335e338dde5de12&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=e0965c584a344628&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyOJFf0zKOxcdVI9gMSL1YXaNQCN8NbHCMiShY8r0m7vGubcIk_IraV6Q4r_7f3-lTeGGEwHGOdCKx0CzPkdhjQQJLdCwlcv60Ip7jH1uO3v5g&indpubnum=5427925295141725&atk=1e1rjjv58f2vf800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=6ffc847995de3d80&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyNDFV-rFpnhmIPrlZfv2Lu0gdqANAVhKyNJILK3xmWeXbOwkyYl_fBfnp3QYWVRHFjxeoy86IoTqDWj4tXf3R7gHqeiOfrcDO4wvLXfvaxkxg&indpubnum=5427925295141725&atk=1e1rjk021bigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=ab6228bc4f4ddce5&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyMIX0-OLgYEooOSiNCbyoj5zowNGm6Uxbxwk3ba-UrTJyn9V9BUoLKGLZzuiJo_0MB-OEEo_wEuJM9wvB6yDIJ-pI29hAd9MSNt-TlMvsM1zam1Aj3izkOw87NHJgxznYA&indpubnum=5427925295141725&atk=1e1rjk0ftf119800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=86822346811dc35e&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyMIX0-OLgYEooOSiNCbyoj5zowNGm6Uxbxwk3ba-UrTJyn9V9BUoLKGLZzuiJo_0MB-OEEo_wEuJM9wvB6yDIJ-pI29hAd9MSNt-TlMvsM1zam1Aj3izkOw87NHJgxznYA&indpubnum=5427925295141725&atk=1e1rjk0ftf119800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=329e838b68ef20a9&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyPzE9NqwBVuH6qxZE1DBISVpOMJV5kFJhnYjhivrm7HqUueM2o8sg4LbBd0O2-tdLVefmX0g9EU0f2GrrLPp8KYF4lGjFmijUPM8KcicAV2GA&indpubnum=5427925295141725&atk=1e1rjk151ngmi801																			");
		urls.add("	http://www.indeed.com/pagead/clk?mo=r&ad=-6NYlbfkN0DuFI_MT1SfQCM8jVLgjKplokPzsgrZ_a9bHRScHUw_j8BnIl60I2R6LdbH0Rx5TIA1v8THjD-ypTS5brIF9ICnfRgOYGzzOZzRCAgBWFRvg4EJ-UK2ZPIx5AkO5l4ysGs80uiDZuX0vSg10dRYNrvJKf7Z_TYhNW3YhYK9AG8ECSqZjHMdmhdCVdZ7H0JcGgfS9gyPfPlgOqw3URBi43Mk9gLThU4rLuATL0qSS1_h4yO6JprILt8ls8QjKePvYyrJI6UEohP7RYUDkzImOuzMcS2C7dkZlijfOM5m5ZLvjMcWUP0Lrl29w5p2MkTpvQwzqmjnbqi9GZOg_KT_7uZIFnNqPvHNnGt8MXt8_LGLD_IHnluH7ZJmtieLGPPDttgE9b9ddwDeYXNPxHlv_COKgZysYWdMBVm_owZCnW7fsUxMj4WHX50QEl5HbOJftMpv9XtE8L2r6u5CLBK-9j5TT3HucJi_1uSX8jhaTYviZzrv_KaBQ3oaBCG5ma1qS5pWpYXEg-e2iUCPZqn_XbTd6RTZVr0ckVhYdimKemQSLyYEy4vnYYtoXok-ajOpH7XOFLRbVfcZdw==&p=0&rjs=1&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=a02552484199da9c&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=8aa58389d55d655b&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=363e5fd92f4618af&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=99f18c474f65fdab&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=d3a249fc956876d9&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=f032db63a3c3565e&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=6c5bd5918262184e&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=d4ba6665f850252a&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=36650ce0ff273aca&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=c4d29f6457c4a993&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=8cf00e5e12a923b9&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=4220bc3d25cda2fb&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=f4cb083d29b34e7d&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=e9dd43359de93a1c&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=9c197570631995ce&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=14489f28fbeb104d&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=1ed17dc0eda8b933&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=9ab6cbcb790248d4&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=ce5ad53691f2ba31&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bCv7N1sZqKusHXvk0AjhzAnONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk2bcf1b4801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=654770c139900d61&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=0e6ebdd36944b809&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=5dc519ce7dd1b012&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=a9f3ffbbf5af45d8&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=343714f30e24fded&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=2d2df781d9e0139c&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=0d24651962d1b671&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=62a6c9ebc59c413c&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=174ed1d4ca0bda98&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=43b089d27e954598&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=24829b5c6fd81131&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=f21914ff97d5c3cc&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=338367f72c3a4512&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=93ed6040e6318d20&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=1400a672571f2f82&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=cf8b4cf7714a576c&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=73fdac6e351113cc&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=b9a7be23bc8ec7de&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=afc21dad310d2421&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=8c17eab9abec7b61&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=df41cfcbc39b5f1f&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=443a8dcc4a0bd376&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bDo_xWOBqEwju0TOVtJVV1xONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk881bif8801																			");
		urls.add("	http://www.indeed.com/viewjob?jk=42341c7a8d7842aa&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=0c36ddd6d36a16c0&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=8955483be23a56f4&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=c4bf66b28221fec3&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=b88c7ecc77e4630d&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=77b1f242f43b7ad0&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=ec5c6b27eb8bc663&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=dc4e917bdf30a673&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=99f551649b08ed42&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=83a36e6bab55d1ab&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=4c0e519aeeef594e&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=995cbcc0ff414a5b&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=b9eeb9b82f42b355&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=0de95970fb75e2d7&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=ff06fd1450670876&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=81b84ffd468192ee&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/viewjob?jk=ad64f3e81e49a923&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwPPmNAR9XOY7gru7qeBn0bBYvrIFjYdTTX-sAlO_5aczONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjk9ttbigt800																			");
		urls.add("	http://www.indeed.com/pagead/clk?mo=r&ad=-6NYlbfkN0ByjEOJNPME_-JPGrq604UpliuNXNmcl20-hP1wuNGXDEA81kd0jw5Cv2wpzDYH6LT4SUKk_hQYFM7U5Ui-QFpb-gd_gfX8rjbsvcJZKdCN6NtLu2AwEK0lyg8sdi-EcqDINUcMWqP3e5bWE44vdQDAfhBoZ5dHoYxSzG2JL4kEAbiEv0xKk6OCGIKKXqEaWvms7DjH2Ek5yDG-aqA5Tup9deqcJkFhFzPe0jSPok4zf2x1ycihUN-Hsvp3t3ID_wLcDeWF0TEuFqGVHWmk64XaSCEYYrSOrEjMbrflRCbV6lxlS47_6G6cHLhgEbA7Di2Cl5q_8UmbGBTaDeMC4g8_wd7IH9eiXpJeiiiD1fUhUxte8MIauNOo1h5CIfkaQTx79_yBG8owvtvMjztXWmAuO_RI6X9rSJgKZzjAEX8YFfQyUtRDPRJ88WpxcOQK9U3z6ySnDNT7Np2GqmS7zJKDYwx5LK9YuOjOT1l7Pk_az6BgyGvlkUBxliNc7yOM6EzFi0nTE38e4y5tc81wCPoW&p=0&rjs=1&atk=1e1rjkd8t38kh000																			");
		urls.add("	http://www.indeed.com/viewjob?jk=ed02937b413efc6d&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyM9qoKAo0v96wc6LxRWhotSNQCN8NbHCMiShY8r0m7vGpr-1Jw1mRsOesieu-nKTK5T6n93ZzQOImqMxIw2IR36ONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e1rjkd8t38kh000																			");


		Iterator<String> it= urls.iterator();
		Document doc=null;
		Document doc1=null;
		String redirecturl=null;
		String redirecturl1=null;
		while (it.hasNext()) {
			String urlLinks = (String)it.next();	
			try {
				doc=Jsoup.connect(urlLinks).followRedirects(true).get();
				if (doc!=null) {
					Elements firstLink=doc.select("div[class=icl-u-lg-mr--sm icl-u-xs-mr--xs]");
					if(firstLink!=null&&!firstLink.isEmpty()&&firstLink.select("a").attr("href") !="")
					{								
						//System.out.println(firstLink.select("a").attr("href"));
						String firstLinkInside=firstLink.select("a").attr("href");
						doc1=Jsoup.connect(firstLinkInside).followRedirects(true).timeout(10000).get();
						if(doc1!=null) { 
							Elements scriptElement=doc1.select("script");
							String str=scriptElement.toString().substring(scriptElement.toString().indexOf("window._initialData"),scriptElement.toString().indexOf("window._sentryData")); 
							String s=str.replace("<script>", "").replace("window._initialData=","").replace(";</script>", ""); 
							JSONObject object=new JSONObject(s);
							if(object.has("aboutStory")) 
							{
								JSONObject obj=object.getJSONObject("aboutStory");
								if(obj.has("aboutMetadata")) {
									JSONObject obj1=obj.getJSONObject("aboutMetadata");
									if(obj1.has("companyLinks")) 
									{ 
										JSONArray itemsArray =obj1.getJSONArray("companyLinks");
										for (int index = 0, total =itemsArray.length(); index < total; index++) {
											if(!itemsArray.getJSONObject(index).getString("href").contains("twitter")) {
												try {
													if(!itemsArray.getJSONObject(index).getString("href").contains("facebook"))
													{
														if(!itemsArray.getJSONObject(index).getString("href").contains("linkedin")) {
															if(!itemsArray.getJSONObject(index).getString("href").contains("instagram"))
															{
																System.out.println(itemsArray.getJSONObject(index).getString("href")); 
															}
														}
													} 

												} catch (JSONException e)
												{ 
													e.printStackTrace();
												}
											}
										} 
									}
								}else {
									//System.out.println("object is not there");
									Elements secondLink=doc.select("span[class=icl-u-lg-inline icl-us-xs-hide]");
									if (secondLink!=null && !secondLink.isEmpty()) {
										for (Element element : secondLink) {
											try {
												redirecturl=element.tagName("a").children().attr("href");
												Response response = Jsoup.connect(redirecturl).execute();
												System.out.println(response.url());
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									}else {
										System.out.println("no links");
									}
								}
							}else {
								//System.out.println("object is not there");
								Elements secondLink=doc.select("span[class=icl-u-lg-inline icl-us-xs-hide]");
								if (secondLink!=null && !secondLink.isEmpty()) {
									for (Element element : secondLink) {
										try {

											redirecturl=element.tagName("a").children().attr("href");
											Response response = Jsoup.connect(redirecturl).execute();
											System.out.println(response.url());
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								}else {
									System.out.println("no links");
								}
							}
						} 
					}else
					{	
						Elements secondLink=doc.select("span[class=icl-u-lg-inline icl-us-xs-hide]");
						if (secondLink!=null && !secondLink.isEmpty()) {
							for (Element element : secondLink) {
								try {
									redirecturl=element.tagName("a").children().attr("href");
									Response response = Jsoup.connect(redirecturl).execute();
									System.out.println(response.url());
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}else
						{
							Elements thirdLink=doc.select("div");
							if (thirdLink!=null && !thirdLink.isEmpty()) {

								for (Element applyLink : thirdLink) {
									try {
										if(applyLink.select("a[class=icl-Button icl-Button--primary icl-Button--md]").first().attr("href")!="")
										{
											//System.out.println(applyLink.getElementsByClass("icl-Button icl-Button--primary icl-Button--md").attr("href"));
											if(!applyLink.select("a[class=icl-Button icl-Button--primary icl-Button--md]").attr("href").contentEquals("/promo/resume"))
											{	
												redirecturl1=applyLink.select("a[class=icl-Button icl-Button--primary icl-Button--md]").attr("href");
												Response response1 = Jsoup.connect(redirecturl1).execute();
												System.out.println(response1.url());
											}else
											{
												System.out.println("no links");
											}
										}
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}catch (Exception e) {
				//e.printStackTrace();
			}  
		}   
	}
}
