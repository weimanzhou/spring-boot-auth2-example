delete from oauth_client_details;

insert into oauth_client_details(id, resource_ids, scope,
                                 authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity,
                                 refresh_token_validity, additional_information, autoapprove, client_id, client_secret)

values ('testid2', 'res1', 'all', 'password', 'http://www.baidu.com', 'p1', 9200, 259200, '', false, 'snowflake', '$2a$10$vvc4MHWnTQ2uvK9x22sNdOpsydrnm06p3uPDsZVX/EEa3v3aROVFm');
