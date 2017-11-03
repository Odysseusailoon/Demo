package ui;

import datahelper.DataHelper;
import dataimpl.InfoImpl;
import dataservice.InfoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import po.InfoPO;

import java.util.ArrayList;


public class DemoController {
    @FXML
    TableView table;

    public Button button;

    public TextField field1;

    public TextField field2;

   public  TableColumn NameCol;
    public TableColumn NumberCol ;

    ObservableList<InfoPO> data;
    ArrayList<InfoPO> list=new ArrayList<>();
    InfoService infoService=new InfoImpl();
    public void initialize(){
        refresh();
        button.setOnAction(e->{
            if(field1.getText().equals("")||field2.getText().equals("")){
                System.out.println("请填写相关信息");
            }else{
                data.add(new InfoPO(field1.getText(),field2.getText()));
                table.setItems(data);
            }
        });
    }
    public void refresh(){
        try{
            list=infoService.getAllInFo();
        }catch(Exception e){
           System.out.println("无法找到");
        }
        ObservableList<InfoPO> data =
                FXCollections.observableArrayList(
                );
        try {
            for (InfoPO flowerPo : list) {
                data.add(flowerPo);
            }
        }catch(Exception e){
        }
        table.setItems(data);
    }
}
