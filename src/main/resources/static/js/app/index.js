var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-search').on('click', function () {
                    _this.search();
                });
        $('#btn-category').on('click', function () {
                            _this.category();
                        });
    },
     save : function () {

            var data = {
                title: $('#title').val(),
                author: $('#author').val(),
                content: $('#summernote').val(),
                category: $('#category').val()

            };
             if($('#title').val() == ""){
                            alert("제목을 입력해주세요");
                            return;
                            }
            if($('#category').val() == "Please Select"){
                    alert("카테고리를 선택해주세요");
                    return;
                    }
               if($('#summernote').val() == ""){
                                    alert("내용을 입력해주세요");
                                    return;
                                    }
            if($('#category').val() == "direct"){

                var data = {
                            title: $('#title').val(),
                            author: $('#author').val(),
                            content: $('#summernote').val(),
                            category: $('#selboxDirect').val()

                        };

            }
            $.ajax({
                type: 'POST',
                url: '/api/v1/posts',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 등록되었습니다.');
                window.location.href = '/posts/blog';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#summernote').val(),
            category: $('#category').val()

        };
         if($('#category').val() == "Please Select"){
                        alert("카테고리를 선택해주세요");
                        return;
                        }
                   if($('#summernote').val() == ""){
                                        alert("내용을 입력해주세요");
                                        return;
                                        }
        if($('#category').val() == "direct"){

                    var data = {
                                title: $('#title').val(),
                                content: $('#summernote').val(),
                                category: $('#selboxDirect').val()

                            };

                }

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/posts/blog';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete : function () {
        var id = $('#id').val();
        if (confirm("정말 삭제하시겠습니까??") == true){    //확인

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/posts/blog';
        }).fail(function (error) {
            alert("삭제 권한이 없습니다.");
        });
        }else{
        return;
        }
    },
     search :function () {

               var search = $('#search').val();


             if($('#search').val() == ""){
                            alert("검색어를 입력해주세요");
                            return;
                            }

            $.ajax({
               type: 'PUT',
               url: '/api/v1/posts/'+id,
               dataType: 'json',
               contentType:'application/json; charset=utf-8'

            }).done(function() {
                alert("검색");
                window.location.href = 'blog/search';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

         category : function () {
                var data = {
                     category: $('#category').val()

                };
                alert(category);

                $.ajax({
                    type: 'GET',
                    url: '/posts/category/'+category,
                    dataType: 'json',
                    contentType:'application/json; charset=utf-8',
                    data: JSON.stringify(data)
                }).done(function() {
                    alert('검색');

                }).fail(function (error) {
                    alert(JSON.stringify(error));
                });
            },


};

main.init();