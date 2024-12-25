//logout 로직
function logoutBtn(){
    $.ajax({
        url: '/user/logout',
        type: 'get',
        data: '',
        //dataType: 'json',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        success: function(data) {
            location.href = /*[[@{/}]]*/ '/';
        },
        error: function(err) {
            console.log(err);
        },
    });
}

function myPageBtn(){
    var params = {

    }
    CommonUtil.openPopup('/myPage/myPagePop', params, '마이페이지', 1400, 600, '');
}

function myTravelBtn(){
    var params = {

    }
    CommonUtil.openPopup('/myPage/myTravelPop', params, '마이페이지', 1400, 600, '');
}
