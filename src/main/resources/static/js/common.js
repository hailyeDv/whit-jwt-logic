$ajax = {
    defaultOptionss : {
        url: $url.getPath(),
        contentType: 'application/json',
    },

    post: function (options) {
        options = $.extend({}, this.defaultOptionss, options);
        $.ajax({
            url: options.url,
            type: "POST",
            data: JSON.stringify(options.data),
            contentType: options.contentType
        }).done(function (data) {
            if (options.success) {
                options.success(data);
            } else {
                $url.redirect();
            }
        }).fail(function (error) {
            if (options.error) {
                options.error(error.responseJSON);
            } else {
                alert(error.responseJSON);
            }
        });
    },
    put: function (options) {
        options = $.extend({}, this.defaultOptions, options);

        $.ajax({
            url: options.url,
            type: 'PUT',
            data: JSON.stringify(options.data),
            contentType: options.contentType,
        }).done(function (data) {
            if (options.success) {
                options.success(data);
            } else {
                $url.redirect();
            }
        }).fail(function (error) {
            if (options.error) {
                options.error(error.responseJSON);
            } else {
                alert(error.responseJSON);
            }
        });
    },
    get: function (options) {
        options = $.extend({}, this.defaultOptions, options);

        $.ajax({
            url: options.url,
            type: 'GET',
            contentType: options.contentType,
        }).done(function (data) {
            if (options.success) {
                options.success(data);
            } else {
                $url.redirect();
            }
        }).fail(function (error) {
            if (options.error) {
                options.error(error.responseJSON);
            } else {
                alert(error.responseJSON);
            }
        });
    },
    delete: function (options) {
        options = $.extend({}, this.defaultOptions, options);

        $.ajax({
            url: options.url,
            type: 'DELETE',
            data: JSON.stringify(options.data),
            contentType: options.contentType,
        }).done(function (data) {
            alert("삭제 되었습니다.");

            if (options.success) {
                options.success(data);
            } else {
                $url.redirect();
            }
        }).fail(function (error) {
            if (options.error) {
                options.error(error.responseJSON);
            } else {
                console.log(error);
                alert(error.responseJSON);
            }
        });
    }
}

$url = {
    getPath: function (extPath) {
        if (extPath && extPath[0] != '/') extPath = '/' + extPath;
        return location.pathname + (extPath ? extPath : '');
    },
    redirect: function (path) {
        location.href = path ? path : this.getPath();
    },
}