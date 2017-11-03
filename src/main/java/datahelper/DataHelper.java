package datahelper;

import util.ResultMessage;

import java.util.ArrayList;

public interface DataHelper<T> {
    public ResultMessage save(T t);

    public ArrayList<T> getAll();
}
