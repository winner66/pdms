package com.chk.pdms.common.utils;

import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ChkResource {
    private CloseableHttpClient httpClient;

    private Logger log = LoggerFactory.getLogger(ChkResource.class);

    public ChkResource() {
        init();
    }

    private void init() {
        BasicCookieStore cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        BasicClientCookie c1 = new BasicClientCookie("JSESSIONID", "FCA72C37A2B1D6D9A3CE385DA8900294");
        c1.setDomain("116.62.26.69");
        cookieStore.addCookie(c1);
    }

    public void download(String url, String local) {
        HttpGet httpGet = null;
        try {
            RequestConfig timeoutConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(1000).setSocketTimeout(500000000).build();
            httpGet = new HttpGet(url);
            httpGet.setConfig(timeoutConfig);
            HttpResponse downLoadResponse = httpClient.execute(httpGet);
            StatusLine statusLine = downLoadResponse.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = downLoadResponse.getEntity();
                InputStream input = entity.getContent();
                File dest = new File(local);
                OutputStream output = new FileOutputStream(dest);
                int len;
                byte[] ch = new byte[10240];
                while ((len = input.read(ch)) != -1) {
                    output.write(ch, 0, len);
                }
                output.flush();
                output.close();
            }
        } catch (Exception e) {
            log.error("", e);
        } finally {
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
        }
    }

    public static void main(String[] args) {
        String url = "http://116.62.26.69:8088/hket-internet/manage/show_file.shtml?filePath=";
        ChkResource chk = new ChkResource();
        for (int i = 0; i < Pdf.pdfs.length; i++) {
            String local = "e:/pdf/" + i + ".pdf";
            chk.download(url + Pdf.pdfs[i], local);
        }
    }

    @Data
    static class Pdf {
        static String[] pdfs = {
                "product/1525422768084/产品手册.pdf",
                "product/1525422927896/产品手册.pdf",
                "product/1525422704925/产品手册.pdf",
                "product/1525422985205/产品手册.pdf",
                "product/1525423069155/产品手册.pdf",
                "product/1525423115794/产品手册.pdf",
                "product/1525423148374/产品手册.pdf",
                "product/1525423433566/产品手册.pdf",
                "product/1525423546363/产品手册.pdf",
                "product/1525423606279/产品手册.pdf",
                "product/1525423656196/产品手册.pdf",
                "product/1525423795726/产品手册.pdf",
                "product/1525423817249/产品手册.pdf",
                "product/1524738856589/产品手册.pdf",
                "product/1525422954955/产品手册.pdf",
                "product/1525423080536/产品手册.pdf",
                "product/1525423093349/产品手册.pdf",
                "product/1525423890648/产品手册.pdf",
                "product/1525423913044/产品手册.pdf",
                "product/1525423941345/产品手册.pdf",
                "product/1525423971698/产品手册.pdf",
                "product/1525423990758/产品手册.pdf",
                "product/1525423674465/产品手册.pdf",
                "product/1525423691530/产品手册.pdf",
                "product/1525423731260/产品手册.pdf",
                "product/1525423751223/产品手册.pdf",
                "product/1525423771310/产品手册.pdf",
                "product/1525424181839/产品手册.pdf",
                "product/1525424212219/产品手册.pdf",
                "product/1525424244958/产品手册.pdf",
                "product/1525424279056/产品手册.pdf",
                "product/1525424194296/产品手册.pdf",
                "product/1525424222656/产品手册.pdf",
                "product/1525424255492/产品手册.pdf",
                "product/1525424296836/产品手册.pdf",
                "product/1525424455510/产品手册.pdf",
                "product/1525424495434/产品手册.pdf",
                "product/1525423450183/产品手册.pdf",
                "product/1525423466870/产品手册.pdf",
                "product/1525423483258/产品手册.pdf",
                "product/1525423497350/产品手册.pdf",
                "product/1525423512948/产品手册.pdf",
                "product/1525423624710/产品手册.pdf",
                "product/1525423565201/产品手册.pdf",
                "product/1525423580824/产品手册.pdf",
                "product/1525424755334/产品手册.pdf",
                "product/1525424774319/产品手册.pdf",
                "product/1525423169431/产品手册.pdf",
                "product/1525423189533/产品手册.pdf",
                "product/1525423262546/产品手册.pdf",
                "product/1525423283878/产品手册.pdf",
                "product/1525423319234/产品手册.pdf",
                "product/1525423359171/产品手册.pdf",
                "product/1525423381458/产品手册.pdf",
                "product/1525423400390/产品手册.pdf",
                "product/1525424914917/产品手册.pdf",
                "product/1525424950596/产品手册.pdf",
                "product/1525424970341/产品手册.pdf",
                "product/1525424987975/产品手册.pdf",
                "product/1525425014490/产品手册.pdf",
                "product/1525425030288/产品手册.pdf",
                "product/1525425047853/产品手册.pdf",
                "product/1525424471878/产品手册.pdf",
                "product/1524924172447/产品手册.pdf",
                "product/1524924185525/产品手册.pdf",
                "product/1524924202572/产品手册.pdf",
                "product/1524924251231/产品手册.pdf",
                "product/1524924263377/产品手册.pdf",
                "product/1524924278766/产品手册.pdf",
                "product/1525420340915/产品手册.pdf",
                "product/1525068693275/产品手册.pdf",
                "product/1525068718433/产品手册.pdf",
                "product/1525068749750/产品手册.pdf",
                "product/1525068764856/产品手册.pdf",
                "product/1525070162910/产品手册.pdf",
                "product/1525070175773/产品手册.pdf",
                "product/1525421998323/产品手册.pdf",
                "product/1525422023699/产品手册.pdf",
                "product/1524906242568/产品手册.pdf",
                "product/1524906295504/产品手册.pdf",
                "product/1524906314760/产品手册.pdf",
                "product/1524906333848/产品手册.pdf",
                "product/1524906353474/产品手册.pdf",
                "product/1524923597689/产品手册.pdf",
                "product/1524923625089/产品手册.pdf",
                "product/1524923641700/产品手册.pdf",
                "product/1524923656081/产品手册.pdf",
                "product/1524924073074/产品手册.pdf",
                "product/1525070056122/产品手册.pdf",
                "product/1525070086414/产品手册.pdf",
                "product/1525070218068/产品手册.pdf",
                "product/1524905710302/产品手册.pdf",
                "product/1524905776874/产品手册.pdf",
                "product/1524905928872/产品手册.pdf",
                "product/1524906033918/产品手册.pdf",
                "product/1524906630312/产品手册.pdf",
                "product/1524924513248/产品手册.pdf",
                "product/1525413322056/产品手册.pdf",
                "product/1525413351127/产品手册.pdf",
                "product/1525413379766/产品手册.pdf",
                "product/1524906172781/产品手册.pdf",
                "product/1524923817183/产品手册.pdf",
                "product/1524923829906/产品手册.pdf",
                "product/1524923842360/产品手册.pdf",
                "product/1524923855746/产品手册.pdf",
                "product/1524926172679/产品手册.pdf",
                "product/1524926238647/产品手册.pdf",
                "product/1524926277934/产品手册.pdf",
                "product/1524926302883/产品手册.pdf",
                "product/1525071165134/产品手册.pdf",
                "product/1525421574149/产品手册.pdf",
                "product/1525071175036/产品手册.pdf",
                "product/1525421635527/产品手册.pdf",
                "product/1524926367337/产品手册.pdf",
                "product/1525010287240/产品手册.pdf",
                "product/1525010321121/产品手册.pdf",
                "product/1525010344260/产品手册.pdf",
                "product/1525069988126/产品手册.pdf",
                "product/1525070012047/产品手册.pdf",
                "product/1525070896700/产品手册.pdf",
                "product/1525412737824/产品手册.pdf",
                "product/1525412818516/产品手册.pdf",
                "product/1524906660858/产品手册.pdf",
                "product/1525070787553/产品手册.pdf",
                "product/1525070809702/产品手册.pdf",
                "product/1525070826888/产品手册.pdf",
                "product/1525070066336/产品手册.pdf",
                "product/1525070096818/产品手册.pdf",
                "product/1524905872430/产品手册.pdf",
                "product/1524906045751/产品手册.pdf",
                "product/1525071005006/产品手册.pdf",
                "product/1524923716200/产品手册.pdf",
                "product/1524923731451/产品手册.pdf",
                "product/1524923745463/产品手册.pdf",
                "product/1524923759594/产品手册.pdf",
                "product/1524926250877/产品手册.pdf",
                "product/1524926290134/产品手册.pdf",
                "product/1524926327651/产品手册.pdf",
                "product/1525010449973/产品手册.pdf",
                "product/1525010301261/产品手册.pdf",
                "product/1525010331722/产品手册.pdf",
                "product/1525418672518/产品手册.pdf",
                "product/1525010499146/产品手册.pdf",
                "product/1525069999019/产品手册.pdf",
                "product/1525421744544/产品手册.pdf",
                "product/1525412865004/产品手册.pdf",
                "product/1524924558108/产品手册.pdf",
                "product/1525405878804/产品手册.pdf",
                "product/1524901192214/产品手册.pdf",
                "product/1524900727064/产品手册.pdf",
                "product/1524906424162/产品手册.pdf",
                "product/1524901171846/产品手册.pdf",
                "product/1524924465245/产品手册.pdf",
                "product/1524924320134/产品手册.pdf",
                "product/1524924452056/产品手册.pdf",
                "product/1524924383102/产品手册.pdf",
                "product/1524924397127/产品手册.pdf",
                "product/1524924370668/产品手册.pdf",
                "product/1524905301358/产品手册.pdf",
                "product/1524905337089/产品手册.pdf",
                "product/1524906488251/产品手册.pdf",
                "product/1524906513715/产品手册.pdf",
                "product/1524906538192/产品手册.pdf",
                "product/1524923926105/产品手册.pdf",
                "product/1524924838084/产品手册.pdf",
                "product/1524924852096/产品手册.pdf",
                "product/1524924863162/产品手册.pdf",
                "product/1524924875731/产品手册.pdf",
                "product/1524905633659/产品手册.pdf",
                "product/1524905651555/产品手册.pdf",
                "product/1524924918466/产品手册.pdf",
                "product/1524924930088/产品手册.pdf",
                "product/1524924944907/产品手册.pdf",
                "product/1524924957258/产品手册.pdf",
                "product/1524924969403/产品手册.pdf",
                "product/1524925088449/产品手册.pdf",
                "product/1524925111885/产品手册.pdf",
                "product/1524925136311/产品手册.pdf",
                "product/1524926028820/产品手册.pdf",
                "product/1525010572746/产品手册.pdf",
                "product/1525071099705/产品手册.pdf",
                "product/1525071117165/产品手册.pdf",
                "product/1525070323813/产品手册.pdf",
                "product/1525070336312/产品手册.pdf",
                "product/1524926072817/产品手册.pdf",
                "product/1524926108564/产品手册.pdf",
                "product/1524926119500/产品手册.pdf",
                "product/1524926131666/产品手册.pdf",
                "product/1525068641807/产品手册.pdf",
                "product/1525069911043/产品手册.pdf",
                "product/1525069924689/产品手册.pdf",
                "product/1525070452855/产品手册.pdf",
                "product/1525070467226/产品手册.pdf",
                "product/1525070745441/产品手册.pdf",
                "product/1525070545441/产品手册.pdf",
                "product/1525071331981/产品手册.pdf",
                "product/1525071345492/产品手册.pdf",
                "product/1524906587088/产品手册.pdf",
                "product/1524923977754/产品手册.pdf",
                "product/1524923990216/产品手册.pdf",
                "product/1524924002584/产品手册.pdf",
                "product/1524924603680/产品手册.pdf",
                "product/1524924615053/产品手册.pdf",
                "product/1524924627156/产品手册.pdf",
                "product/1524924639535/产品手册.pdf",
                "product/1524905416909/产品手册.pdf",
                "product/1524905434360/产品手册.pdf",
                "product/1524924686796/产品手册.pdf",
                "product/1524924699305/产品手册.pdf",
                "product/1524924715178/产品手册.pdf",
                "product/1524924728373/产品手册.pdf",
                "product/1524924742044/产品手册.pdf",
                "product/1524925010019/产品手册.pdf",
                "product/1524925097384/产品手册.pdf",
                "product/1524925123958/产品手册.pdf",
                "product/1524925147477/产品手册.pdf",
                "product/1525010534596/产品手册.pdf",
                "product/1525071068042/产品手册.pdf",
                "product/1525071087893/产品手册.pdf",
                "product/1525070259001/产品手册.pdf",
                "product/1525070269923/产品手册.pdf",
                "product/1524925193803/产品手册.pdf",
                "product/1524925953525/产品手册.pdf",
                "product/1524925968185/产品手册.pdf",
                "product/1524925980115/产品手册.pdf",
                "product/1525068589191/产品手册.pdf",
                "product/1525069852730/产品手册.pdf",
                "product/1525069866129/产品手册.pdf",
                "product/1525070392298/产品手册.pdf",
                "product/1525070406755/产品手册.pdf",
                "product/1525070601594/产品手册.pdf",
                "product/1525070507575/产品手册.pdf",
        };
    }
}
