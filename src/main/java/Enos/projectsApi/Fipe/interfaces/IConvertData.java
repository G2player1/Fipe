package Enos.projectsApi.Fipe.interfaces;

import java.util.List;

public interface IConvertData {

    <T> T getData(String json, Class<T> classe);

    <T> List<T> getDataList(String json, Class<T> classe);
}
