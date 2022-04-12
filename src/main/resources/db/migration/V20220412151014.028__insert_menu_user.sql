INSERT INTO `e_upms_menu` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `code`, `icon`, `name`, `param`, `sort`, `status`, `type`, `value`, `parent_menu_id`)
VALUES (NULL, 'erupt', '2022-04-12 15:10:14', 'erupt', '2022-04-12 15:10:14', 'Ee8xV4sG', NULL, 'User', NULL, NULL, '1', 'table', 'User', null);

set @parentId = @@identity;

INSERT INTO `e_upms_menu` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `code`, `icon`, `name`, `param`, `sort`, `status`, `type`, `value`, `parent_menu_id`)
VALUES (NULL, NULL, '2022-04-12 15:10:14', NULL, NULL, 'PtW0SDZd', NULL, '新增', NULL, '10', '1', 'button', 'User@ADD', @parentId);

INSERT INTO `e_upms_menu` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `code`, `icon`, `name`, `param`, `sort`, `status`, `type`, `value`, `parent_menu_id`)
VALUES (NULL, NULL, '2022-04-12 15:10:14', NULL, NULL, 'TwH68XVJ', NULL, '修改', NULL, '20', '1', 'button', 'User@EDIT', @parentId);

INSERT INTO `e_upms_menu` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `code`, `icon`, `name`, `param`, `sort`, `status`, `type`, `value`, `parent_menu_id`)
VALUES (NULL, NULL, '2022-04-12 15:10:14', NULL, NULL, 'mVuC91at', NULL, '删除', NULL, '30', '1', 'button', 'User@DELETE', @parentId);

INSERT INTO `e_upms_menu` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `code`, `icon`, `name`, `param`, `sort`, `status`, `type`, `value`, `parent_menu_id`)
VALUES (NULL, NULL, '2022-04-12 15:10:14', NULL, NULL, 'P0p9VTjQ', NULL, '导出', NULL, '40', '1', 'button', 'User@EXPORT', @parentId);

INSERT INTO `e_upms_menu` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `code`, `icon`, `name`, `param`, `sort`, `status`, `type`, `value`, `parent_menu_id`)
VALUES (NULL, NULL, '2022-04-12 15:10:14', NULL, NULL, '5MAKOdl9', NULL, '导入', NULL, '50', '1', 'button', 'User@IMPORTABLE', @parentId);

INSERT INTO `e_upms_menu` (`id`, `create_by`, `create_time`, `update_by`, `update_time`, `code`, `icon`, `name`, `param`, `sort`, `status`, `type`, `value`, `parent_menu_id`)
VALUES (NULL, NULL, '2022-04-12 15:10:14', NULL, NULL, 'hZYyY3IH', NULL, '详情', NULL, '60', '1', 'button', 'User@VIEW_DETAIL', @parentId);
