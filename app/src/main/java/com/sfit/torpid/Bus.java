package com.sfit.torpid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

/*import com.example.kewin.torpid.QRCode;
import com.example.kewin.torpid.R;
import com.sfit.torpid.QRCode;*/

public class Bus extends AppCompatActivity {

    CharSequence[] station_s = {"DAHISAR BRIDGE", "DAHISAR BUS STATION", "DAHISAR CHECK NAKA (E)","DAHISAR MARKET","DAHISAR PHATAK (W)", "DAHISAR STATION (W)","DAHISAR STATION ROAD (E)","GANESH MANDIR DAHISAR","GANPAT PATIL NAGAR (DAHISAR)","GOKUL ANAND DAHISAR","MUNICIPAL HOSPITAL DAHISAR","RUSHI COMPLEX DAHISAR","SARASWATI COMPLEX (DAHISAR)","SHEJAL PARK DAHISAR","SHIVAJI NAGAR DAHISAR","VAISHALI NAGAR DAHISAR","WALMIKI SOCIETY (DAHISAR)","KANDAR PADA","ANAND NAGAR (DAHISAR)","BHAKTI PALACE (DAHISAR)","JUHU BEACH", "PARSI COLONY JUHU", "JUHU HOTEL", "SARASWAT BANK", "JUHU BUS STATION", "BHARATIYA AROGYA NIDHI HOSPITAL", "UTPAL SANGHAVI SCHOOL", "CHANDAN CINEMA", "J.V.P.D.BUS STATION", "JUHU SHOPPING CENTRE", "NEW INDIA QUARTERS", "MANOBINA APARTMENTS", "SHOPPERS STOP ANDHERI", "ANDHERI STATION (W)", "ANDHERI MARKET", "AMBOLI NAKA", "FAROOKH VIDYALAYA", "JOGESHWARI BUS STATION", "JOGESHWARI TABELA", "JOGESHWARI TELEPHONE EXCHANGE", "AJIT GLASS FACTORY", "OSHIWARA BRIDGE", "RAM MANDIR GOREGAON", "SAHARA", "GOREGAON POLICE STATION", "JAWAHAR NAGAR",  "PATKAR COLLEGE", "MADINA MANZIL", "SUNDER NAGAR MALAD", "CHINCHOLI PHATAK / SARVODAYA SCHOOL", "RANI SATI NAGAR", "NEW ERA TALKIES", "MALAD STATION (W)", "N.L.VIDYALAYA", "MILAP TALKIES", "BAL BHARATI / HITAVARDHAK HALL", "JAIN MANDIR KANDIVALI",  "KANDIVALI STATION (W)","SHATABDI HOSPITAL", "KANDIVALI TELEPHONE EXCHANGE", "POISAR DEPOT", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "KORA KENDRA", "BORIVALI JAIL (W)", "DHARAMSHI HALL", "BORIVALI STATION ROAD (W)","PAI NAGAR", "RAM MANDIR BORIVALI", "BHAGWATI HOSPITAL", "TECHNICAL SCHOOL", "MARY IMMACULATE SCHOOL", "NAVA GAON","GOREGAON BUS STATION (W)", "JAIN MANDIR GOREGAON", "FILMISTAN", "RAM BAUG GOREGAON","C.C.I.COLONY", "MOTILAL NAGAR NO 2", "BANGUR NAGAR POLICE CHOWKEY", "BANGUR NAGAR", "INORBIT MALL", "VINAY INDUSTRY (SUBKUCH MARKET)", "NIRLON SOCIETY", "CHINCHOLI BUNDER ROAD", "RAJAN PADA", "KACH PADA", "EVERSHINE NAGAR", "MITH CHOWKY MALAD", "JANATA COLONY/SHIV MANDIR", "LALJIPADA POLICE CHOWKY", "SHANTI NAGAR KANDIVALI", "DAHANUKAR WADI", "VAISHALI BHAVAN", "KALA MARUTI MANDIR", "DENA BANK KANDIVALI","BORIVALI PHATAK (W)", "RAJHANS SOCIETY BORIVALI", "SAI AMRUT SOCIETY", "GOMANT NAGAR","D MART SHOPPING CENTRE", "SINDHI COLONY", "MEHRABAD BAUG", "M.GANDHI VIDYALAYA JOGESHWARI", "BEHRAM BAUG", "ANAND NAGAR (OSHIWARA)", "GOREGAON / OSHIWARA DEPOT", "BHAGAT SINGH NAGAR", "SHASTRI NAGAR (LINK ROAD) GOREGAON", "MADHUR COLONY", "MUNICIPAL SCHOOL MALAD", "MALVANI DEPOT / GAIKWAD NAGAR", "MALVANI BLOCK NO 7", "MALVANI BLOCK NO 6", "MALVANI BLOCK NO 5", "FIRE BRIGADE / KHARODI COLONY", "TOWNSHIP MUNICIPAL SCHOOL MALAD", "ASMITA JYOTI", "EKTA NAGAR MALAD", "KANDIVALI ESTATE / GANESH NAGAR", "HINDUSTAN NAKA / CHARANSINGH CHOWK", "YADAV NAGAR", "SAVE NAGAR", "VIDYA MANDIR", "ANAND NAGAR MARKET", "ANAND HOSPITAL", "VITTHAL RAKHMAI MANDIR", "KETAKI PADA", "VESAVE-YARI ROAD BUS STATION", "GANGA BHUWAN", "MACHHALIMAR VERSOVA", "SEVEN BUNGALOWS BUS STATION", "FOUR BUNGALOWS", "INDIAN OIL NAGAR ANDHERI", "LAXMI INDUSTRIAL ESTATE", "AAI TULJABHAVANI CHOWK/LOKHANDWALA COMPLEX", "ADARSH NAGAR (OSH)", "ORLEM CHURCH", "CHOKSI HOSPITAL", "NOVELTY SILK MILLS", "GOLDEN CHEMICALS", "MAHA VISHNU / SAMRAT HOTEL", "TRANSPORT CORPORATION", "KASHI MIRA", "PUNJAB FOUNDRY", "GREEN LAWN ACADEMY", "HITCO", "SILVER PARK", "SUNDER NAGAR MIRA ROAD", "S.K.STONE MIRA ROAD", "BEVERLY PARK", "SHIVAR GARDEN", "CHAITANYA HOSPITAL MIRA ROAD", "SHREENATH COMPLEX MIRA ROAD", "GOLDEN NEST", "AZAD NAGAR MIRA ROAD", "BHAYANDER PHATAK (POLICE CHOWKY)", "KASTURI ESTATE", "ABHINAV SCHOOL", "GHODDEO NAKA", "RAM NAGAR BHAYANDAR", "NAVGHAR NAKA", "VINAS APARTMENT", "SALSAR NAGAR", "BHAIDAYA NAGAR BHYNDR", "KHARI GAON", "BHAYANDER MARKET", "BHAYANDER STATION (E)"};
    CharSequence[] station_d = {"DAHISAR BRIDGE", "DAHISAR BUS STATION", "DAHISAR CHECK NAKA (E)","DAHISAR MARKET","DAHISAR PHATAK (W)", "DAHISAR STATION (W)","DAHISAR STATION ROAD (E)","GANESH MANDIR DAHISAR","GANPAT PATIL NAGAR (DAHISAR)","GOKUL ANAND DAHISAR","MUNICIPAL HOSPITAL DAHISAR","RUSHI COMPLEX DAHISAR","SARASWATI COMPLEX (DAHISAR)","SHEJAL PARK DAHISAR","SHIVAJI NAGAR DAHISAR","VAISHALI NAGAR DAHISAR","WALMIKI SOCIETY (DAHISAR)","KANDAR PADA","ANAND NAGAR (DAHISAR)","BHAKTI PALACE (DAHISAR)","JUHU BEACH", "PARSI COLONY JUHU", "JUHU HOTEL", "SARASWAT BANK", "JUHU BUS STATION", "BHARATIYA AROGYA NIDHI HOSPITAL", "UTPAL SANGHAVI SCHOOL", "CHANDAN CINEMA", "J.V.P.D.BUS STATION", "JUHU SHOPPING CENTRE", "NEW INDIA QUARTERS", "MANOBINA APARTMENTS", "SHOPPERS STOP ANDHERI", "ANDHERI STATION (W)", "ANDHERI MARKET", "AMBOLI NAKA", "FAROOKH VIDYALAYA", "JOGESHWARI BUS STATION", "JOGESHWARI TABELA", "JOGESHWARI TELEPHONE EXCHANGE", "AJIT GLASS FACTORY", "OSHIWARA BRIDGE", "RAM MANDIR GOREGAON", "SAHARA", "GOREGAON POLICE STATION", "JAWAHAR NAGAR",  "PATKAR COLLEGE", "MADINA MANZIL", "SUNDER NAGAR MALAD", "CHINCHOLI PHATAK / SARVODAYA SCHOOL", "RANI SATI NAGAR", "NEW ERA TALKIES", "MALAD STATION (W)", "N.L.VIDYALAYA", "MILAP TALKIES", "BAL BHARATI / HITAVARDHAK HALL", "JAIN MANDIR KANDIVALI",  "KANDIVALI STATION (W)","SHATABDI HOSPITAL", "KANDIVALI TELEPHONE EXCHANGE", "POISAR DEPOT", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "KORA KENDRA", "BORIVALI JAIL (W)", "DHARAMSHI HALL", "BORIVALI STATION ROAD (W)","PAI NAGAR", "RAM MANDIR BORIVALI", "BHAGWATI HOSPITAL", "TECHNICAL SCHOOL", "MARY IMMACULATE SCHOOL", "NAVA GAON","GOREGAON BUS STATION (W)", "JAIN MANDIR GOREGAON", "FILMISTAN", "RAM BAUG GOREGAON","C.C.I.COLONY", "MOTILAL NAGAR NO 2", "BANGUR NAGAR POLICE CHOWKEY", "BANGUR NAGAR", "INORBIT MALL", "VINAY INDUSTRY (SUBKUCH MARKET)", "NIRLON SOCIETY", "CHINCHOLI BUNDER ROAD", "RAJAN PADA", "KACH PADA", "EVERSHINE NAGAR", "MITH CHOWKY MALAD", "JANATA COLONY/SHIV MANDIR", "LALJIPADA POLICE CHOWKY", "SHANTI NAGAR KANDIVALI", "DAHANUKAR WADI", "VAISHALI BHAVAN", "KALA MARUTI MANDIR", "DENA BANK KANDIVALI","BORIVALI PHATAK (W)", "RAJHANS SOCIETY BORIVALI", "SAI AMRUT SOCIETY", "GOMANT NAGAR","D MART SHOPPING CENTRE", "SINDHI COLONY", "MEHRABAD BAUG", "M.GANDHI VIDYALAYA JOGESHWARI", "BEHRAM BAUG", "ANAND NAGAR (OSHIWARA)", "GOREGAON / OSHIWARA DEPOT", "BHAGAT SINGH NAGAR", "SHASTRI NAGAR (LINK ROAD) GOREGAON", "MADHUR COLONY", "MUNICIPAL SCHOOL MALAD", "MALVANI DEPOT / GAIKWAD NAGAR", "MALVANI BLOCK NO 7", "MALVANI BLOCK NO 6", "MALVANI BLOCK NO 5", "FIRE BRIGADE / KHARODI COLONY", "TOWNSHIP MUNICIPAL SCHOOL MALAD", "ASMITA JYOTI", "EKTA NAGAR MALAD", "KANDIVALI ESTATE / GANESH NAGAR", "HINDUSTAN NAKA / CHARANSINGH CHOWK", "YADAV NAGAR", "SAVE NAGAR", "VIDYA MANDIR", "ANAND NAGAR MARKET", "ANAND HOSPITAL", "VITTHAL RAKHMAI MANDIR", "KETAKI PADA", "VESAVE-YARI ROAD BUS STATION", "GANGA BHUWAN", "MACHHALIMAR VERSOVA", "SEVEN BUNGALOWS BUS STATION", "FOUR BUNGALOWS", "INDIAN OIL NAGAR ANDHERI", "LAXMI INDUSTRIAL ESTATE", "AAI TULJABHAVANI CHOWK/LOKHANDWALA COMPLEX", "ADARSH NAGAR (OSH)", "ORLEM CHURCH", "CHOKSI HOSPITAL", "NOVELTY SILK MILLS", "GOLDEN CHEMICALS", "MAHA VISHNU / SAMRAT HOTEL", "TRANSPORT CORPORATION", "KASHI MIRA", "PUNJAB FOUNDRY", "GREEN LAWN ACADEMY", "HITCO", "SILVER PARK", "SUNDER NAGAR MIRA ROAD", "S.K.STONE MIRA ROAD", "BEVERLY PARK", "SHIVAR GARDEN", "CHAITANYA HOSPITAL MIRA ROAD", "SHREENATH COMPLEX MIRA ROAD", "GOLDEN NEST", "AZAD NAGAR MIRA ROAD", "BHAYANDER PHATAK (POLICE CHOWKY)", "KASTURI ESTATE", "ABHINAV SCHOOL", "GHODDEO NAKA", "RAM NAGAR BHAYANDAR", "NAVGHAR NAKA", "VINAS APARTMENT", "SALSAR NAGAR", "BHAIDAYA NAGAR BHYNDR", "KHARI GAON", "BHAYANDER MARKET", "BHAYANDER STATION (E)"};
    CharSequence[] bus203 = {"JUHU BEACH", "PARSI COLONY JUHU", "JUHU HOTEL", "SARASWAT BANK", "JUHU BUS STATION", "BHARATIYA AROGYA NIDHI HOSPITAL", "UTPAL SANGHAVI SCHOOL", "CHANDAN CINEMA", "J.V.P.D.BUS STATION", "JUHU SHOPPING CENTRE", "NEW INDIA QUARTERS", "MANOBINA APARTMENTS", "SHOPPERS STOP ANDHERI", "ANDHERI STATION (W)", "ANDHERI MARKET", "AMBOLI NAKA", "FAROOKH VIDYALAYA", "JOGESHWARI BUS STATION", "JOGESHWARI TABELA", "JOGESHWARI TELEPHONE EXCHANGE", "AJIT GLASS FACTORY", "OSHIWARA BRIDGE", "RAM MANDIR GOREGAON", "SAHARA", "GOREGAON POLICE STATION", "JAWAHAR NAGAR", "FILMISTAN", "PATKAR COLLEGE", "MADINA MANZIL", "SUNDER NAGAR MALAD", "CHINCHOLI PHATAK / SARVODAYA SCHOOL", "RANI SATI NAGAR", "NEW ERA TALKIES", "MALAD STATION (W)",      "N.L.VIDYALAYA", "MILAP TALKIES", "BAL BHARATI / HITAVARDHAK HALL", "JAIN MANDIR KANDIVALI", "KANDIVALI STATION (W)",          "SHATABDI HOSPITAL", "KANDIVALI TELEPHONE EXCHANGE", "POISAR DEPOT", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "KORA KENDRA", "BORIVALI JAIL (W)", "DHARAMSHI HALL", "BORIVALI STATION ROAD (W)",         "BORIVALI STATION ROAD (W)",         "BORIVALI STATION ROAD (W)",         "PAI NAGAR", "RAM MANDIR BORIVALI", "BHAGWATI HOSPITAL", "TECHNICAL SCHOOL", "SHIVAJI NAGAR DAHISAR", "MARY IMMACULATE SCHOOL", "NAVA GAON", "KANDAR PADA", "DAHISAR BRIDGE"};
    CharSequence[] bus204={"GOREGAON BUS STATION (W)", "JAIN MANDIR GOREGAON", "JAWAHAR NAGAR", "FILMISTAN", "RAM BAUG GOREGAON", "LOKMANYA TILAK NAGAR GOREGAON", "C.C.I.COLONY", "MITHA NAGAR", "MOTILAL NAGAR NO 2", "BANGUR NAGAR POLICE CHOWKEY", "BANGUR NAGAR", "INORBIT MALL", "VINAY INDUSTRY (SUBKUCH MARKET)", "NIRLON SOCIETY", "CHINCHOLI BUNDER ROAD", "RAJAN PADA", "KACH PADA", "EVERSHINE NAGAR", "MITH CHOWKY MALAD", "JANATA COLONY/SHIV MANDIR", "LALJIPADA POLICE CHOWKY", "SHANTI NAGAR KANDIVALI", "DAHANUKAR WADI", "VAISHALI BHAVAN", "KANDIVALI VILLAGE", "M.GANDHI SWIMMING POOL KANDIVALI", "KALA MARUTI MANDIR", "DENA BANK KANDIVALI", "KANDIVALI STATION (W)",          "SHATABDI HOSPITAL", "KANDIVALI TELEPHONE EXCHANGE", "POISAR DEPOT", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "KORA KENDRA", "BORIVALI JAIL (W)", "DHARAMSHI HALL", "BORIVALI STATION ROAD (W)",         "BORIVALI STATION ROAD (W)",         "BORIVALI PHATAK (W)", "RAJHANS SOCIETY BORIVALI", "SAI AMRUT SOCIETY", "GOMANT NAGAR", "DAHISAR PHATAK (W)", "DAHISAR STATION (W)",        "MUNICIPAL HOSPITAL DAHISAR", "DAHISAR BRIDGE", "KANDAR PADA", "NAVA GAON", "MARY IMMACULATE SCHOOL", "SHIVAJI NAGAR DAHISAR", "TECHNICAL SCHOOL", "BHAGWATI HOSPITAL", "RAM MANDIR BORIVALI", "PAI NAGAR", "BORIVALI STATION ROAD (W)",         "BORIVALI STATION ROAD (W)",         "DHARAMSHI HALL", "BORIVALI JAIL (W)", "KORA KENDRA", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "POISAR DEPOT", "KANDIVALI TELEPHONE EXCHANGE", "SHATABDI HOSPITAL", "KANDIVALI STATION (W)",          "DENA BANK KANDIVALI", "KALA MARUTI MANDIR", "M.GANDHI SWIMMING POOL KANDIVALI", "KANDIVALI VILLAGE", "VAISHALI BHAVAN", "DAHANUKAR WADI", "SHANTI NAGAR KANDIVALI", "LALJIPADA POLICE CHOWKY", "JANATA COLONY/SHIV MANDIR", "MITH CHOWKY MALAD", "EVERSHINE NAGAR", "KACH PADA", "D MART SHOPPING CENTRE", "RAJAN PADA", "CHINCHOLI BUNDER ROAD", "NIRLON SOCIETY", "VINAY INDUSTRY (SUBKUCH MARKET)", "BANGUR NAGAR", "BANGUR NAGAR POLICE CHOWKEY", "MOTILAL NAGAR NO 2", "MITHA NAGAR", "C.C.I.COLONY", "LOKMANYA TILAK NAGAR GOREGAON", "RAM BAUG GOREGAON", "FILMISTAN", "JAIN MANDIR GOREGAON", "GOREGAON BUS STATION (W)"};

    CharSequence[] bus205 = {"JOGESHWARI BUS STATION", "JOGESHWARI TABELA", "JOGESHWARI TELEPHONE EXCHANGE", "SINDHI COLONY", "MEHRABAD BAUG", "M.GANDHI VIDYALAYA JOGESHWARI", "BEHRAM BAUG", "ANAND NAGAR (OSHIWARA)", "GOREGAON / OSHIWARA DEPOT", "BHAGAT SINGH NAGAR", "SHASTRI NAGAR (LINK ROAD) GOREGAON", "BANGUR NAGAR POLICE CHOWKEY", "BANGUR NAGAR", "INORBIT MALL", "VINAY INDUSTRY (SUBKUCH MARKET)", "NIRLON SOCIETY", "CHINCHOLI BUNDER ROAD", "MADHUR COLONY", "MUNICIPAL SCHOOL MALAD", "CHINCHOLI PHATAK / SARVODAYA SCHOOL", "RANI SATI NAGAR", "NEW ERA TALKIES", "MALAD STATION (W)",      "N.L.VIDYALAYA","MILAP TALKIES", "BAL BHARATI / HITAVARDHAK HALL", "JAIN MANDIR KANDIVALI", "KANDIVALI STATION (W)",          "SHATABDI HOSPITAL", "KANDIVALI TELEPHONE EXCHANGE", "POISAR DEPOT", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "KORA KENDRA", "BORIVALI JAIL (W)", "DHARAMSHI HALL", "BORIVALI STATION ROAD (W)",         "BORIVALI STATION ROAD (W)",         "PAI NAGAR", "RAM MANDIR BORIVALI", "BHAGWATI HOSPITAL", "TECHNICAL SCHOOL", "SHIVAJI NAGAR DAHISAR", "MARY IMMACULATE SCHOOL", "NAVA GAON", "KANDAR PADA", "DAHISAR BRIDGE", "MUNICIPAL HOSPITAL DAHISAR", "DAHISAR STATION (W)",        "DAHISAR PHATAK (W)", "GOMANT NAGAR", "SAI AMRUT SOCIETY", "RAJHANS SOCIETY BORIVALI", "BORIVALI PHATAK (W)", "BORIVALI STATION ROAD (W)",         "BORIVALI STATION ROAD (W)",         "DHARAMSHI HALL", "BORIVALI JAIL (W)", "KORA KENDRA", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "POISAR DEPOT", "KANDIVALI TELEPHONE EXCHANGE", "SHATABDI HOSPITAL", "KANDIVALI STATION (W)",          "JAIN MANDIR KANDIVALI", "BAL BHARATI / HITAVARDHAK HALL", "MILAP TALKIES", "N.L.VIDYALAYA", "MALAD STATION (W)",      "NEW ERA TALKIES", "RANI SATI NAGAR", "CHINCHOLI PHATAK / SARVODAYA SCHOOL", "MUNICIPAL SCHOOL MALAD", "MADHUR COLONY", "CHINCHOLI BUNDER ROAD", "NIRLON SOCIETY", "VINAY INDUSTRY (SUBKUCH MARKET)", "INORBIT MALL", "BANGUR NAGAR", "BANGUR NAGAR POLICE CHOWKEY", "SHASTRI NAGAR (LINK ROAD) GOREGAON", "BHAGAT SINGH NAGAR", "GOREGAON / OSHIWARA DEPOT", "ANAND NAGAR (OSHIWARA)", "BEHRAM BAUG", "M.GANDHI VIDYALAYA JOGESHWARI", "MEHRABAD BAUG", "SINDHI COLONY", "JOGESHWARI TELEPHONE EXCHANGE", "JOGESHWARI TABELA", "JOGESHWARI BUS STATION"};
    CharSequence[] bus207 = {"MALVANI DEPOT / GAIKWAD NAGAR", "MALVANI BLOCK NO 7", "MALVANI BLOCK NO 6", "MALVANI BLOCK NO 5", "FIRE BRIGADE / KHARODI COLONY", "TOWNSHIP MUNICIPAL SCHOOL MALAD", "ASMITA JYOTI", "EKTA NAGAR MALAD", "KANDIVALI ESTATE / GANESH NAGAR", "HINDUSTAN NAKA / CHARANSINGH CHOWK", "YADAV NAGAR", "DAHANUKAR WADI", "VAISHALI BHAVAN", "KANDIVALI VILLAGE", "M.GANDHI SWIMMING POOL KANDIVALI", "KALA MARUTI MANDIR", "DENA BANK KANDIVALI", "KANDIVALI STATION (W)", "SHATABDI HOSPITAL", "KANDIVALI TELEPHONE EXCHANGE", "POISAR DEPOT", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "KORA KENDRA", "BORIVALI JAIL (W)", "DHARAMSHI HALL", "BORIVALI STATION ROAD (W)", "BORIVALI STATION ROAD (W)", "BORIVALI STATION ROAD (W)", "PAI NAGAR", "RAM MANDIR BORIVALI", "BHAGWATI HOSPITAL", "TECHNICAL SCHOOL", "SHIVAJI NAGAR DAHISAR", "MARY IMMACULATE SCHOOL", "NAVA GAON", "KANDAR PADA", "DAHISAR BRIDGE", "DAHISAR MARKET", "SAVE NAGAR", "VIDYA MANDIR", "ANAND NAGAR MARKET", "ANAND HOSPITAL", "VITTHAL RAKHMAI MANDIR", "KETAKI PADA", "DAHISAR CHECK NAKA (E)", "DAHISAR BUS STATION"};
    CharSequence[] bus210 = {"VESAVE-YARI ROAD BUS STATION", "GANGA BHUWAN", "MACHHALIMAR VERSOVA", "SEVEN BUNGALOWS BUS STATION", "FOUR BUNGALOWS", "INDIAN OIL NAGAR ANDHERI", "LAXMI INDUSTRIAL ESTATE", "AAI TULJABHAVANI CHOWK/LOKHANDWALA COMPLEX", "ADARSH NAGAR (OSH)", "BEHRAM BAUG", "GOREGAON / OSHIWARA DEPOT", "SHASTRI NAGAR (LINK ROAD) GOREGAON", "BANGUR NAGAR POLICE CHOWKEY", "BANGUR NAGAR", "INORBIT MALL", "VINAY INDUSTRY (SUBKUCH MARKET)", "CHINCHOLI BUNDER ROAD", "D MART SHOPPING CENTRE", "KACH PADA", "EVERSHINE NAGAR", "ORLEM CHURCH", "CHOKSI HOSPITAL", "N.L.VIDYALAYA", "MILAP TALKIES", "BAL BHARATI / HITAVARDHAK HALL", "KANDIVALI STATION (W)", "POISAR DEPOT", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "KORA KENDRA", "BORIVALI JAIL (W)", "DHARAMSHI HALL", "BORIVALI STATION ROAD (W)", "BORIVALI STATION ROAD (W)", "BORIVALI STATION ROAD (W)", "PAI NAGAR", "BHAGWATI HOSPITAL", "TECHNICAL SCHOOL", "MARY IMMACULATE SCHOOL", "NAVA GAON", "KANDAR PADA", "DAHISAR BRIDGE"};
    CharSequence[] bus707 = {"GOREGAON / OSHIWARA DEPOT", "SHASTRI NAGAR (LINK ROAD) GOREGAON", "BANGUR NAGAR POLICE CHOWKEY", "BANGUR NAGAR", "INORBIT MALL", "VINAY INDUSTRY (SUBKUCH MARKET)", "CHINCHOLI BUNDER ROAD", "KACH PADA", "D MART SHOPPING CENTRE", "EVERSHINE NAGAR", "ORLEM CHURCH", "CHOKSI HOSPITAL", "N.L.VIDYALAYA", "MILAP TALKIES", "BAL BHARATI / HITAVARDHAK HALL", "KANDIVALI STATION (W)", "KANDIVALI TELEPHONE EXCHANGE", "POISAR DEPOT", "RAM BAUG / SHASTRI NAGAR KANDIVALI", "KORA KENDRA", "BORIVALI JAIL (W)", "DHARAMSHI HALL", "BORIVALI STATION ROAD (W)", "BORIVALI STATION ROAD (W)", "BORIVALI STATION ROAD (W)", "PAI NAGAR", "BHAGWATI HOSPITAL","TECHNICAL SCHOOL", "SHIVAJI NAGAR DAHISAR", "MARY IMMACULATE SCHOOL", "NAVA GAON", "DAHISAR BRIDGE", "DAHISAR MARKET", "SAVE NAGAR", "VIDYA MANDIR", "NOVELTY SILK MILLS", "KETAKI PADA", "DAHISAR CHECK NAKA (E)", "GOLDEN CHEMICALS", "MAHA VISHNU / SAMRAT HOTEL", "TRANSPORT CORPORATION", "KASHI MIRA", "PUNJAB FOUNDRY", "GREEN LAWN ACADEMY", "HITCO", "SILVER PARK", "SUNDER NAGAR MIRA ROAD", "S.K.STONE MIRA ROAD", "BEVERLY PARK", "SHIVAR GARDEN", "CHAITANYA HOSPITAL MIRA ROAD", "SHREENATH COMPLEX MIRA ROAD", "GOLDEN NEST", "AZAD NAGAR MIRA ROAD", "BHAYANDER PHATAK (POLICE CHOWKY)", "KASTURI ESTATE", "ABHINAV SCHOOL", "GHODDEO NAKA", "RAM NAGAR BHAYANDAR", "NAVGHAR NAKA", "VINAS APARTMENT", "SALSAR NAGAR", "BHAIDAYA NAGAR BHYNDR", "KHARI GAON", "BHAYANDER MARKET", "BHAYANDER STATION (E)"};
    Vector<String> vec = new Vector<>(4,4);

    CharSequence[] busnoafter={"203","204","205","207","210","707"};
    String source1,dest1,tick1, busnostring;
    int p1,p2,p3 = 1;
    int flag1=0, flag2=0, flag3=0, flag3_1=0, checks=0,checkd=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);


        //station=getResources().getStringArray(R.array.station);
        final AutoCompleteTextView source = (AutoCompleteTextView) findViewById(R.id.bus_sp1);
        final AutoCompleteTextView destination = (AutoCompleteTextView) findViewById(R.id.bus_sp2);
        final AutoCompleteTextView busno = (AutoCompleteTextView) findViewById(R.id.bus_sp3);
        ArrayAdapter<CharSequence> adapter1 = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_dropdown_item_1line, station_s);
        ArrayAdapter<CharSequence> adapter2 = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_dropdown_item_1line, station_d);
        final ArrayAdapter<CharSequence> adapter3 = new
                  //ArrayAdapter<CharSequence>(this, android.R.layout.simple_dropdown_item_1line, vec.toArray(new String[vec.size()]));
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_dropdown_item_1line, busnoafter);
        source.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                source.showDropDown();
                return false;

            }
        });

        destination.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                destination.showDropDown();
                return false;
            }
        });

        busno.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (flag1 == 0 || flag2 == 0) {
                    Toast.makeText(Bus.this, "Please set source and dest first", Toast.LENGTH_SHORT).show();
                    return false;
                } else {
                    if(flag3==0) {
                        flag3 = 1;
                        int j = 0;
                        for (int checks = 0, checkd = 0, i = 0; i < bus203.length; i++) {
                            if (bus203[i] == source1) {
                                checks++;
                            } else if (bus203[i] == dest1) {
                                checkd++;
                                if (checks == 1 && checkd == 1)
                                    vec.add("203");
                                break;
                            }
                        }
                        for (int checks = 0, checkd = 0, i = 0; i < bus204.length; i++) {
                            if (bus204[i] == source1) {
                                checks++;
                            } else if (bus204[i] == dest1) {
                                checkd++;
                                if (checks == 1 && checkd == 1) {
                                    vec.add("204");
                                    //busnoafter[j++] = "bus204";
                                    break;
                                }
                            }
                        }
                        for (int checks = 0, checkd = 0, i = 0; i < bus205.length; i++) {
                            if (bus205[i] == source1) {
                                checks++;
                            } else if (bus205[i] == dest1) {
                                checkd++;
                                if (checks == 1 && checkd == 1)
                                    vec.add("205");
                                //busnoafter[j++] = "bus205";
                                break;
                            }
                        }
                        for (int checks = 0, checkd = 0, i = 0; i < bus207.length; i++) {
                            if (bus207[i] == source1) {
                                checks++;
                            } else if (bus207[i] == dest1) {
                                checkd++;
                                if (checks == 1 && checkd == 1)
                                    vec.add("207");
                                // busnoafter[j++] = "bus207";
                                break;
                            }
                        }
                        for (int checks = 0, checkd = 0, i = 0; i < bus210.length; i++) {
                            if (bus210[i] == source1) {
                                checks++;
                            } else if (bus210[i] == dest1) {
                                checkd++;
                                if (checks == 1 && checkd == 1)
                                    vec.add("210");
                                //busnoafter[j++] = "bus210";
                                break;
                            }
                        }
                        for (int checks = 0, checkd = 0, i = 0; i < bus707.length; i++) {
                            if (bus707[i] == source1) {
                                checks++;
                            } else if (bus707[i] == dest1) {
                                checkd++;
                                if (checks == 1 && checkd == 1)
                                    vec.add("707");
                                //busnoafter[j++] = "bus707";
                                break;
                            }
                        }
                        //Toast.makeText(Bus.this, vec.toString(), Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Bus.this, vec.toString(), Toast.LENGTH_SHORT).show();
                    busno.showDropDown();
                    return false;
                }
            }
        });

        source.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                flag1 = 1;
                InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(arg1.getApplicationWindowToken(), 0);
                //abc = Long.toString(arg3);
                //showToast("LONG "+abc);
                //showToast(arg0.getItemAtPosition(arg2).toString());
                source1 = arg0.getItemAtPosition(arg2).toString();
            }

        });

        destination.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                flag2 = 1;
                InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(arg1.getApplicationWindowToken(), 0);
                dest1 = arg0.getItemAtPosition(arg2).toString();

                p2 = arg2;
            }

        });
        busno.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if(vec.contains(arg0.getItemAtPosition(arg2).toString())) {
                    flag3_1 = 1;
                    InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(arg1.getApplicationWindowToken(), 0);
                    //abc = Long.toString(arg3);
                    //showToast("LONG "+abc);
                    //showToast(arg0.getItemAtPosition(arg2).toString());
                    //Toast.makeText(Bus.this,"Yes",Toast.LENGTH_SHORT).show();
                    busnostring = arg0.getItemAtPosition(arg2).toString();
                }
                else{Toast.makeText(Bus.this,"This bus does not stop at the desired source/destination",Toast.LENGTH_LONG).show();}
                busnostring = arg0.getItemAtPosition(arg2).toString();
            }

        });


        source.setThreshold(0);         //So that when u type the first letter itself, the dropdown option will begin.
        source.setAdapter(adapter1);     //To start the dropdown thing.
        destination.setThreshold(0);    //So that when u type the first letter itself, the dropdown option will begin.
        destination.setAdapter(adapter2);
        busno.setThreshold(0);         //So that when u type the first letter itself, the dropdown option will begin.
        busno.setAdapter(adapter3);


        NumberPicker np = (NumberPicker) findViewById(R.id.bus_sp4);
        np.setMinValue(1);
        np.setMaxValue(6);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){
            @Override
            public void onValueChange(NumberPicker np, int oldv, int newv)
            {
                tick1 = Integer.toString(newv);
                p3 = newv;
            }
        });



        //TODO THIS ISN'T WORKING PLEASE CHECK. UPDATE : NOW IT IS.


        Button btnStart = (Button) findViewById(R.id.button3);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag1==0 && flag2==0){showToast("Please select source and destination.");}
                else if(flag1==0){showToast("Please select source");}
                else if(flag2==0){showToast("Please select destination.");}
                else if(flag3_1==0){showToast("The bus number is invalid. Please change it to "+vec.toString());}
                else if(source1.equals(dest1))
                {showToast("Please select different source and destination.");}
                else
                {
                    vec.removeAllElements();
                    flag3=0;
                    flag3_1=0;
                    String z = "Source: "+source1+ " \nDest: "+dest1+"\nNo. of ticks: "+p3+"\nBus Number: "+busnostring;
                    Intent s = new Intent(Bus.this, QRCode.class);
                    Intent in = getIntent();
                    String abc = in.getStringExtra("key");
                    z = abc+"\n"+z;
                    s.putExtra("KEWIN",z);
                    startActivity(s);
                }
                //showToast(z);
                /*Intent s = new Intent(Bus.this, QRCode.class);
                s.putExtra("KEWIN",z);
                startActivity(s);*/
            }
        });
    }

    void showToast(CharSequence msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();
    }
}