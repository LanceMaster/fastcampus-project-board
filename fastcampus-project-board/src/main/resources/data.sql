/*계정*/
insert into user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
    ('uno', 'asdf1234', 'Uno', 'Jhk3@mail.com', 'I am Uno.', now(), 'uno', now(), 'uno')
;

/*게시글*/
insert into article (user_account_id, title, content, hashtag, created_by, modified_by, created_at, modified_at) values
                    (1, 'Quisque ut erat.', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.
Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.
Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', '#pink', 'Kamilah', 'Murial', '2021-05-30 23:53:46', '2021-03-10 08:48:50'),

                                                                                                                     (1, 'Morbi ut odio.', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.
Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.
Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', '#purple', 'Arv', 'Keelby', '2021-05-06 11:51:24', '2021-05-23 08:34:54'),
                    (1, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '#purple', 'Adams', 'Thalia', '2021-08-13 08:32:22', '2021-04-02 02:58:19');
/*댓글*/
insert into article_comment (article_id, user_account_id, content, created_at, modified_at, created_by, modified_by) values
                                                                                                                         (1,1,'content test', '2021-03-02 22:40:04', '2021-04-27 15:38:09', 'Lind', 'Orv');
