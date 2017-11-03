package dataservice;

import po.InfoPO;
import util.ResultMessage;

import java.util.ArrayList;

public interface InfoService {
    public ResultMessage saveInfo(InfoPO infoPO);

    public ArrayList<InfoPO> getAllInFo();

}
