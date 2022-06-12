var obj = {
    signup: function () {
        $ajax.post({
            url: $url.getPath("signup"),
            data: {
                username: $("#username").val(),
                password: $("#password").val(),
                gender: getGender()
            },
            success: function (json) {
                alert("가입이 완료되었습니다.");
                location.href = "/login";
            }
        })
    }
}

function getGender() {
    $("input[name='gender']:checked").each(function (){
        return this.id;
    });

    return null;
}