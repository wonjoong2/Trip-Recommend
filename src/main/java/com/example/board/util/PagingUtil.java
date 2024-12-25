package com.example.board.util;

import java.util.Map;

public class PagingUtil {


    /**
     * 페이징 처리.
     * page, pageSize 가 숫자 String이라는 전제가 깔려 있음.
     * parseInt에서 runtime 에러가 발생하지 않는다는 전제임.
     */
    public static void setPaging(Map<String, Object> params) {
        final String page = (String)params.get("page");
        final String pageSize = (String)params.get("pageSize");
        if (page != null && pageSize != null) {
            int pageNum = (Integer.parseInt(page) - 1) * Integer.parseInt(pageSize);
            params.put("page", pageNum);
            params.put("pageSize", Integer.parseInt((String) params.get("pageSize")));
        }
    }
    
    /**
     * mssql용 페이징 처리.
     */
    public static void setPagingForMs(Map<String, Object> params) {
        if(params.get("page") != null && params.get("pageSize") != null){
            final int page = Integer.parseInt(params.get("page").toString());
            final int pageSize = Integer.parseInt(params.get("pageSize").toString());
            if( page > 1){
                params.put("startRow", (page - 1) * pageSize + 1 );
            }else{
                params.put("startRow", page);
            }
            params.put("endRow", page * pageSize);
        }
    }

}