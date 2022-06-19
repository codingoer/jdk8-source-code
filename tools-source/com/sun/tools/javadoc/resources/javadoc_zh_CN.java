package com.sun.tools.javadoc.resources;

import java.util.ListResourceBundle;

public final class javadoc_zh_CN extends ListResourceBundle {
   protected final Object[][] getContents() {
      return new Object[][]{{"javadoc.Body_missing_from_html_file", "HTML 文件中缺少主体标记"}, {"javadoc.End_body_missing_from_html_file", "HTML 文件中缺少主体结束标记"}, {"javadoc.File_Read_Error", "读取文件{0}时出错"}, {"javadoc.JavaScript_in_comment", "文档注释中发现 JavaScript。\n使用 --allow-script-in-comments 可允许使用 JavaScript。"}, {"javadoc.Multiple_package_comments", "找到程序包 \"{0}\" 的多个程序包注释源"}, {"javadoc.class_not_found", "找不到类{0}。"}, {"javadoc.error", "错误"}, {"javadoc.error.msg", "{0}: 错误 - {1}"}, {"javadoc.note.msg", "{1}"}, {"javadoc.note.pos.msg", "{0}: {1}"}, {"javadoc.warning", "警告"}, {"javadoc.warning.msg", "{0}: 警告 - {1}"}, {"main.Building_tree", "正在构造 Javadoc 信息..."}, {"main.Loading_source_file", "正在加载源文件{0}..."}, {"main.Loading_source_files_for_package", "正在加载程序包{0}的源文件..."}, {"main.No_packages_or_classes_specified", "未指定程序包或类。"}, {"main.Xusage", "  -Xmaxerrs <number>               设置要输出的最大错误数\n  -Xmaxwarns <number>              设置要输出的最大警告数\n"}, {"main.Xusage.foot", "这些选项都是非标准选项, 如有更改, 恕不另行通知。"}, {"main.cant.read", "无法读取{0}"}, {"main.doclet_class_not_found", "找不到 doclet 类{0}"}, {"main.doclet_method_must_be_static", "在 doclet 类{0}中, 方法{1}必须为静态。"}, {"main.doclet_method_not_accessible", "在 doclet 类{0}中, 无法访问方法{1}"}, {"main.doclet_method_not_found", "doclet 类{0}不包含{1}方法"}, {"main.done_in", "[在 {0} 毫秒内完成]"}, {"main.error", "{0} 个错误"}, {"main.errors", "{0} 个错误"}, {"main.exception_thrown", "在 doclet 类{0}中, 方法{1}已抛出异常错误{2}"}, {"main.fatal.error", "致命错误"}, {"main.fatal.exception", "致命异常错误"}, {"main.file_not_found", "找不到文件: \"{0}\""}, {"main.illegal_locale_name", "语言环境不可用: {0}"}, {"main.illegal_package_name", "非法的程序包名称: \"{0}\""}, {"main.incompatible.access.flags", "指定了多个 -public, -private, -package 或 -protected。"}, {"main.internal_error_exception_thrown", "内部错误: 在 doclet 类{0}中, 方法{1}已抛出异常错误{2}"}, {"main.invalid_flag", "无效的标记: {0}"}, {"main.locale_first", "在命令行中, 选项 -locale 必须为第一个选项。"}, {"main.malformed_locale_name", "格式错误的语言环境名称: {0}"}, {"main.more_than_one_doclet_specified_0_and_1", "指定了多个 doclet ({0}和{1})。"}, {"main.must_return_boolean", "在 doclet 类{0}中, 方法{1}必须返回布尔值。"}, {"main.must_return_int", "在 doclet 类{0}中, 方法{1}必须返回整型值。"}, {"main.must_return_languageversion", "在 doclet 类{0}中, 方法{1}必须返回语言版本。"}, {"main.no_source_files_for_package", "没有程序包{0}的源文件"}, {"main.option.already.seen", "{0}选项只能指定一次。"}, {"main.out.of.memory", "java.lang.OutOfMemoryError: 请增大内存。\n例如, 对于 JDK 经典或 HotSpot VM, 请增大选项 -J-Xmx,\n例如 -J-Xmx32m。"}, {"main.requires_argument", "选项{0}需要参数。"}, {"main.usage", "用法: javadoc [options] [packagenames] [sourcefiles] [@files]\n  -overview <file>                 从 HTML 文件读取概览文档\n  -public                          仅显示 public 类和成员\n  -protected                       显示 protected/public 类和成员 (默认值)\n  -package                         显示 package/protected/public 类和成员\n  -private                         显示所有类和成员\n  -help                            显示命令行选项并退出\n  -doclet <class>                  通过替代 doclet 生成输出\n  -docletpath <path>               指定查找 doclet 类文件的位置\n  -sourcepath <pathlist>           指定查找源文件的位置\n  -classpath <pathlist>            指定查找用户类文件的位置\n  -cp <pathlist>                   指定查找用户类文件的位置\n  -exclude <pkglist>               指定要排除的程序包列表\n  -subpackages <subpkglist>        指定要递归加载的子程序包\n  -breakiterator                   计算带有 BreakIterator 的第一个语句\n  -bootclasspath <pathlist>        覆盖由引导类加载器所加载的\n                                   类文件的位置\n  -source <release>                提供与指定发行版的源兼容性\n  -extdirs <dirlist>               覆盖所安装扩展的位置\n  -verbose                         输出有关 Javadoc 正在执行的操作的信息\n  -locale <name>                   要使用的区域设置, 例如 en_US 或 en_US_WIN\n  -encoding <name>                 源文件编码名称\n  -quiet                           不显示状态消息\n  -J<flag>                         直接将 <flag> 传递到运行时系统\n  -X                               输出非标准选项的提要\n"}, {"main.warning", "{0} 个警告"}, {"main.warnings", "{0} 个警告"}, {"tag.End_delimiter_missing_for_possible_SeeTag", "注释字符串中可能出现的 See 标记缺少结束分隔符 }: \"{0}\""}, {"tag.Improper_Use_Of_Link_Tag", "内嵌标记缺少结束 ''}'' 字符: \"{0}\""}, {"tag.illegal_char_in_arr_dim", "标记{0}: 数组维中有语法错误, 方法参数: {1}"}, {"tag.illegal_see_tag", "标记{0}: 方法参数中有语法错误: {1}"}, {"tag.missing_comma_space", "标记{0}: 方法参数中缺少逗号或空格: {1}"}, {"tag.see.can_not_find_member", "标记{0}: 在{2}中找不到{1}"}, {"tag.see.class_not_specified", "标记{0}: 未指定类: \"{1}\""}, {"tag.see.illegal_character", "标记{0}: \"{2}\" 中的 \"{1}\" 为非法字符"}, {"tag.see.malformed_see_tag", "标记{0}: 格式错误: \"{1}\""}, {"tag.see.missing_sharp", "标记{0}: 缺少 ''#'': \"{1}\""}, {"tag.see.no_close_bracket_on_url", "标记{0}: 缺少最后的 ''>'': \"{1}\""}, {"tag.see.no_close_quote", "标记{0}: 无右引号: \"{1}\""}, {"tag.serialField.illegal_character", "@serialField 标记中的非法字符 {0}: {1}。"}, {"tag.tag_has_no_arguments", "{0} 标记没有参数。"}};
   }
}
