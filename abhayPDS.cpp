#include<iostream>
#include<cstdio>
 
#include<vector>
#include<algorithm>
 
#define s(i) scanf("%d",&i)
#define ps(i) printf("%d ",i)
#define pa(i) printf("%d\n",i)
#define pn printf("\n")
#define ph printf("here\n")
#define fr(i,s,n) for(int i=s;i<n;i++)
#define blockSize 1000000
using namespace std;
long int preC[]={0,1772320,3440861,5107326,6815514,8500794,10154468,11202407,12971528,14642402,16292691,18024629,19745150,20869251,22425047,24094989,25803118,27454220,29129418,30536076,31900677,33561927,35219210,36930932,38587703,40204813,41292635,43025946,44705363,46328006,48033306,49754604,50871400,52386880,54035787,55673789,57263607,58919507,60348974,61551165,63220091,64977672,66596576,68233073,70011605,71011605,72665469,74306225,75969703,77602162,79238694,80577841,81995832,83685830,85373006,87060217,88782420,90303151,91484187,93182007,94966320,96610048,98279595,100044093,101044093,102044093,103044093,104044093,105044093,106044093,107044093,108044093,109044093,110044093,111044093,112780093,114475079,116123320,117894693,119602640,120793455,122301865,124030027,125704431,127357249,129067315,130485285,131807600,133493898,135165104,136885647,138544880,140185647,141256007,143016550,144702023,146333435,148038875,149771309,150880347,152407583,154054753,155710698,157306518,158975900,160380633,161609665,163297064,165032703,166678390,168317206,170057399,171057399,172760564,174405842,176042931,177704339,179350858,180639202,182061548,183802831,185498500,187154580,188926374,190381116,191626755,193340253,195070758,196779170,198442008,200132696,201132696,202132696,203132696,204132696,205132696,206132696,207132696,208132696,209132696,210132696,211157082,212917370,214596044,216225192,217968186,219668068,220824526,222343705,224049689,225729710,227379904,229077509,230491113,231806086,233470893,235130009,236818120,238467675,240131395,241153708,242920603,244601660,246230894,247965223,249669808,250822383,252290779,253942816,255550041,257128901,258775089,260258363,261390177,263077695,264805599,266422049,268076622,269824017,270911566,272481927,274100005,275759247,277364596,279042350,280432421,281716416,283427210,285130166,286861550,288540120,290177024,291240002,293008598,294703507,296325742,298030876,299747760,300869231,301869231,302869231,303869231,304869231,305869231,306869231,307869231,308869231,309869231,310869231,312436707,314117272,315835515,317506128,319175600,320569593,321953985,323607098,325268707,326971093,328605590,330209875,331302425,333036692,334748742,336390197,338068967,339820048,340911657,342502508,344160756,345859572,347505524,349159065,350549524,351886914,353478024,355079616,356726140,358281970,359960321,360980763,362631103,364319093,366011916,367671066,369343096,370652181,372053154,373707225,375307085,376952265,378564492,380153638,381200087,382958750,384637038,386260691,387978710,389673086,390824993,392392049,394104904,395840759,397523083,399202642,400586087,401586087,402586087,403586087,404586087,405586087,406586087,407586087,408586087,409586087,410586087,412001953,413673071,415346708,417041482,418738110,420280787,421429715,423111594,424881940,426509206,428156302,429940866,430971775,432604378,434273098,435964629,437604581,439273374,440609642,442027075,443728545,445410456,447083819,448820316,450325271,451494972,453096506,454749896,456345605,457972049,459586116,460762244,462230675,463990856,465630253,467275707,469004803,470418534,471664604,473298557,474988835,476546401,478155052,479854526,480920748,482570704,484276898,486019972,487706948,489427570,490693273,492108028,493875783,495527262,497174700,498897106,500364236,501364236,502364236,503364236,504364236,505364236,506364236,507364236,508364236,509364236,510364236,511573134,513187051,514865707,516490340,518079974,519754792,520864522,522360762,524012639,525622247,527203529,528849390,530300502,531449158,533067278,534706056,536301017,537920306,539517140,540731741,542126025,543788120,545393082,547028482,548615041,550168714,551219790,552916926,554519490,556141980,557779118,559372121,560640058,562021971,563610764,565198272,566837018,568391026,570041388,571041388,572621354,574164135,575780679,577312700,578951057,580343484,581526980,583141440,584819032,586425390,588047718,589710746,590839579,592324607,594009384,595604045,597203364,598848406,600322213,601322213,602322213,603322213,604322213,605322213,606322213,607322213,608322213,609322213,610322213,611507961,613187805,614946873,616570602,618208175,619997204,620998979,622659055,624331094,626017939,627673610,629350441,630652182,632066672,633797482,635450138,637099159,638806861,640323600,641508775,643186017,644941402,646558717,648187400,649957820,650979890,652548011,654126237,655777205,657344367,658984235,660381220,661609615,663300202,665035107,666681910,668309702,670050936,671050936,672698648,674305361,675925428,677521380,679126077,680511367,681858794,683550658,685229960,686953086,688603166,690205983,691301409,693045183,694775804,696416066,698083167,699849955,700925357,701925357,702925357,703925357,704925357,705925357,706925357,707925357,708925357,709925357,710925357,712523357,714168501,715842207,717472073,719107878,720507160,721828923,723462291,725091247,726713270,728347461,730028015,731028015,732675404,734303811,735931409,737543014,739150774,740529472,741866403,743493703,745105319,746736106,748357582,750031686,751031686,752607169,754146570,755762547,757302096,758933510,760333782,761510437,763115046,764797046,766348107,768011360,769625849,770794213,772280856,773970832,775565823,777153092,778879330,780323892,781504379,783137082,784837937,786423989,788069519,789758063,790865983,792394155,794054727,795671703,797281079,798967601,800390190,801390190,802390190,803390190,804390190,805390190,806390190,807390190,808390190,809390190,810390190,811638509,813345940,815075237,816776890,818453340,820132104,821156020,822956038,824652307,826306198,828028724,829765766,830876707,832450550,834120296,835837967,837497927,839157036,840548062,841947795,843659118,845366553,847066586,848807190,850320587,851490913,853104186,854782998,856390400,858024821,859675826,860816682,862346028,864063604,865761834,867417159,869095933,870511298,871833590,873470965,875101080,876752430,878387859,880053389,881053389,882836802,884563750,886250619,888012141,889750533,890869007,892442320,894120718,895847034,897506808,899170352,900557245,901557245,902557245,903557245,904557245,905557245,906557245,907557245,908557245,909557245,910557245,911965940,913676800,915360133,917061192,918764437,920308825,921492240,923173702,924941990,926573787,928209475,930001032,931001032,932710590,934435836,936091351,937836291,939539615,940762126,942237501,944005112,945646920,947298162,949014566,950433089,951690903,953292703,954966860,956565741,958139388,959837707,960915723,962540490,964240330,965959584,967622976,969304503,970635097,972034379,973680138,975283023,976945212,978560968,980159304,981206427,982978777,984666038,986301336,988011445,989708724,990847542,992440170,994166093,995913850,997610885,999309588,1000650341,1001650341,1002650341,1003650341,1004650341,1005650341,1006650341,1007650341,1008650341,1009650341,1010650341,1011650341,1012650341,1013650341,1014650341,1015650341,1016650341,1017650341,1018650341,1019650341,1020650341,1021650341,1022650341,1023650341,1024650341,1025650341,1026650341,1027650341,1028650341,1029650341,1030650341,1031650341,1032650341,1033650341,1034650341,1035650341,1036650341,1037650341,1038650341,1039650341,1040650341,1041650341,1042650341,1043650341,1044650341,1045650341,1046650341,1047650341,1048650341,1049650341,1050650341,1051650341,1052650341,1053650341,1054650341,1055650341,1056650341,1057650341,1058650341,1059650341,1060650341,1061650341,1062650341,1063650341,1064650341,1065650341,1066650341,1067650341,1068650341,1069650341,1070650341,1071650341,1072650341,1073650341,1074650341,1075650341,1076650341,1077650341,1078650341,1079650341,1080650341,1081650341,1082650341,1083650341,1084650341,1085650341,1086650341,1087650341,1088650341,1089650341,1090650341,1091650341,1092650341,1093650341,1094650341,1095650341,1096650341,1097650341,1098650341,1099650341,1100650341,1101650341,1102650341,1103650341,1104650341,1105650341,1106650341,1107650341,1108650341,1109650341,1110650341,1112078253,1113833045,1115515290,1117198329,1118974607,1120415545,1121684052,1123374110,1125078136,1126775236,1128450417,1130130649,1131152740,1132918906,1134607011,1136246802,1137995361,1139698830,1140842170,1142396709,1144086663,1145808553,1147478400,1149165350,1150553346,1151907950,1153523358,1155132230,1156825971,1158414809,1160069042,1161069042,1162805343,1164502584,1166120485,1167858602,1169554101,1170764854,1172234682,1173958206,1175577683,1177191050,1178912630,1180356563,1181584018,1183300000,1185048919,1186730410,1188405618,1190107697,1191107697,1192906457,1194620471,1196280678,1198020579,1199743833,1200870038,1201870038,1202870038,1203870038,1204870038,1205870038,1206870038,1207870038,1208870038,1209870038,1210870038,1212447070,1214122840,1215860540,1217524677,1219214920,1220585142,1222001008,1223671014,1225344708,1227040537,1228736077,1230279842,1231424480,1233100003,1234844072,1236472074,1238105505,1239886108,1240942473,1242578123,1244257025,1245987813,1247642252,1249345566,1250647987,1252038882,1253663045,1255266049,1256930146,1258507995,1260112519,1261114505,1262880175,1264559400,1266176058,1267896771,1269584018,1270777343,1272240873,1273940267,1275546078,1277135419,1278851071,1280312737,1281504326,1283211815,1285009045,1286664435,1288335415,1290073251,1291073251,1292816901,1294522771,1296153375,1297890060,1299583904,1300780858,1301780858,1302780858,1303780858,1304780858,1305780858,1306780858,1307780858,1308780858,1309780858,1310780858,1312283073,1314031445,1315702888,1317367210,1319062904,1320492379,1321809350,1323490648,1325153320,1326856036,1328505476,1330155010,1331202284,1332969249,1334660237,1336300986,1338023355,1339739430,1340867105,1342418104,1344096359,1345800106,1347447049,1349102629,1350520308,1351833060,1353431306,1355056435,1356697200,1358252570,1359933700,1360968314,1362614511,1364308800,1366011407,1367673440,1369350450,1370656880,1372057093,1373714093,1375317080,1376975772,1378589084,1380169944,1381223363,1382998590,1384679029,1386303104,1388010904,1389709214,1390846457,1392429709,1394150812,1395895710,1397584002,1399267097,1400622517,1401622517,1402622517,1403622517,1404622517,1405622517,1406622517,1407622517,1408622517,1409622517,1410622517,1412040440,1413746106,1415424082,1417089863,1418833479,1420333693,1421528603,1423215016,1424996490,1426617059,1428283473,1430039207,1431039207,1432730435,1434407099,1436058167,1437742310,1439423451};
struct pt{
int pos, q;
};
 
long int num[10000];
pt a[10000];int a_i=0,ae_i=0,s_i=0,top,bottom;
bool myfn1(pt i,pt j)
{
    if(i.q>j.q)
      return false;
    return true;
}
int main()
{
    int n,tm,prod,sum;
    long int count=0,tocheck=1;
    s(n);
    while(n)
    {
        a[a_i].pos=a_i;
        a[a_i].q=n;
        a_i++;
        s(n);
    }
    sort(a,a+a_i,myfn1);
    int i=0;
 
    while(i<a_i)
    {
        /****BSearch****/
        top=1000;
        bottom=0;
        while(1){
          s_i=(top+bottom)/2;
          if(blockSize*s_i<=a[i].q && a[i].q<(s_i+1)*blockSize)
            break;
          if(a[i].q>s_i*blockSize)
            bottom=s_i+1;
          else if(a[i].q<s_i*blockSize)
            top=s_i-1;
        }
        /***************/
 
        count=(s_i)*blockSize;
 
        tocheck=preC[s_i];
        if(a[i].q==count)
            {
              num[a[i].pos]=tocheck;
              i++;
              continue;
              //break;
            }
 
        for(;a[i].q<blockSize*(s_i+1) && i<a_i;tocheck++)
        {
            tm=tocheck;
            prod=1;sum=0;
            while(tm)
            {
                prod*=tm%10;
                sum+=tm%10;
                tm/=10;
            }
            if(sum)
              if(prod%sum==0)
              {
                count++;
                if(count==a[i].q){
                  num[a[i].pos]=tocheck;
                  i++;
                  //break;
                }
              }
            while(a[i].q==a[i-1].q)
            {
                num[a[i].pos]=tocheck;
                i++;
            }
        }
        //i++;
    }
    for(int i=0;i<a_i;i++)
      printf("%ld\n",num[i]);
}
