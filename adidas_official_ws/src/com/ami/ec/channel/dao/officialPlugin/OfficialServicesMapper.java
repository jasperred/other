package com.ami.ec.channel.dao.officialPlugin;

import java.util.List;
import java.util.Map;

public interface OfficialServicesMapper {
   
    List<Map> searchArticle(Map example);

    List<Map> searchItemPriceOrStock(Map example);
    
    int callPriceUpdateSP(java.util.Map example);
}