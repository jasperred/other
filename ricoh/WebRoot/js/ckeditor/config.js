/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	config.skin = 'v2';
	config.language = 'zh-cn';
	//config.width = 600;
	// 工具栏
	config.toolbar = [
			[ 'Font', 'FontSize', 'Bold', 'Italic', 'Underline', 'Strike',
					'TextColor', 'BGColor', 'JustifyLeft', 'JustifyCenter',
					'JustifyRight', 'JustifyBlock', 'Outdent', 'Indent',
					'NumberedList', 'BulletedList' ],'/',
			[ 'Link', 'Image', 'Source', 'Maximize' ]

	];
};
