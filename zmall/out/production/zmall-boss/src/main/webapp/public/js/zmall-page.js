/**
 * @Name zmall-page
 * @Author sangaizhi
 * @Date 2017/4/9  15:14
 * @Version 1.0
*/
var zmallPage = {
    jumpPageByGet:function(pageNumFixed, pageSizeFixed){
        var pageNum,pageSize;
        if (pageNumFixed) {
            pageNum = pageNumFixed;
        } else {
            pageNum = 1;
        }
        if(pageSizeFixed){
            pageSize = pageSizeFixed;
        }else{
            pageSize=10;
        }
        if (pageNum > 10000 || pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize > 1000 || pageSize < 1) {
            pageSize = 10;
        }
        var href = location.href;
        href = zmallURL.removeParam(href, "pageSize");
        href = zmallURL.removeParam(href, "pageNum");
        href = zmallURL.addParam(href, "pageSize", pageSize);
        href = zmallURL.addParam(href, "pageNum", pageNum);
        location.href = href;
    },
    jumpPageNyPost:function(pageNumFixed, pageSizeFixed, formId) {
        var pageNum,pageSize;
        if (pageNumFixed) {
            pageNum = pageNumFixed;
        } else {
            pageNum = 1;
        }
        if(pageSizeFixed){
            pageSize = pageSizeFixed;
        }else{
            pageSize=10;
        }
        if (pageNum > 10000 || pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize > 1000 || pageSize < 1) {
            pageSize = 10;
        }
        var pageNumInput = $("<input type='hidden' name='pageNum' value='"+ pageNum +"'>")
        var pageSizeInput = $("<input type='hidden' name='pageSize' value='"+ pageSize +"'>")
        $("#"+formId).append(pageNumInput).append(pageSizeInput);
        $("#"+formId).submit();
    }

}