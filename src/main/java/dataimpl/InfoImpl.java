package dataimpl;

import datahelper.DataHelper;
import datahelper.HibernateDataHelper;
import dataservice.InfoService;
import po.InfoPO;
import util.ResultMessage;

import java.util.ArrayList;

public class InfoImpl implements InfoService{
    DataHelper<InfoPO> dataHelper=new HibernateDataHelper<InfoPO>(InfoPO.class);
    @Override
    public ResultMessage saveInfo(InfoPO infoPO) {

        return dataHelper.save(infoPO);
    }

    @Override
    public ArrayList<InfoPO> getAllInFo() {
        return dataHelper.getAll();
    }
}



