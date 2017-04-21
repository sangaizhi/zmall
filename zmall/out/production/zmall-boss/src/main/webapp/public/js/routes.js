/**
 * @Name routers
 * @Author sangaizhi
 * @Date 2017/3/25  11:39
 * @Version 1.0
 */

var routes = {
    base:'http://127.0.0.1:8080',
    category:{
        list:'/category/list',
        add:'/category/add',
        update:'/category/update',
        delete:'/category/delete',
    },
    admin:{
        register:'/admin/login',
        login:'/admin/register',
        check:'/admin/check'
    }
};