package com.sun.tools.javadoc.resources;

import java.util.ListResourceBundle;

public final class javadoc_ja extends ListResourceBundle {
   protected final Object[][] getContents() {
      return new Object[][]{{"javadoc.Body_missing_from_html_file", "HTMLにbodyタグがありません"}, {"javadoc.End_body_missing_from_html_file", "HTMLファイルにbodyの閉じタグがありません"}, {"javadoc.File_Read_Error", "ファイル{0}の読込み中にエラーが発生しました"}, {"javadoc.JavaScript_in_comment", "ドキュメント・コメントにJavaScriptが見つかりました。\n--allow-script-in-commentsを使用して、JavaScriptの使用を許可してください。"}, {"javadoc.Multiple_package_comments", "パッケージ\"{0}\"に複数のパッケージ・コメントのソースが検出されました"}, {"javadoc.class_not_found", "クラス{0}が見つかりません。"}, {"javadoc.error", "エラー"}, {"javadoc.error.msg", "{0}: エラー - {1}"}, {"javadoc.note.msg", "{1}"}, {"javadoc.note.pos.msg", "{0}: {1}"}, {"javadoc.warning", "警告"}, {"javadoc.warning.msg", "{0}: 警告 - {1}"}, {"main.Building_tree", "Javadoc情報を構築しています..."}, {"main.Loading_source_file", "ソース・ファイル{0}を読み込んでいます..."}, {"main.Loading_source_files_for_package", "パッケージ{0}のソース・ファイルを読み込んでいます..."}, {"main.No_packages_or_classes_specified", "パッケージまたはクラスが指定されていません。"}, {"main.Xusage", "  -Xmaxerrs <number>        出力するエラーの最大数を設定する\n  -Xmaxwarns <number>       出力する警告の最大数を設定する\n"}, {"main.Xusage.foot", "これらは非標準オプションであり予告なしに変更されることがあります。"}, {"main.cant.read", "{0}を読み込めません"}, {"main.doclet_class_not_found", "docletクラス{0}が見つかりません"}, {"main.doclet_method_must_be_static", "docletクラス{0}では、メソッド{1}はstaticである必要があります。"}, {"main.doclet_method_not_accessible", "docletクラス{0}では、メソッド{1}にアクセスできません"}, {"main.doclet_method_not_found", "docletクラス{0}にはメソッド{1}がありません"}, {"main.done_in", "[{0}ミリ秒で完了]"}, {"main.error", "エラー{0}個"}, {"main.errors", "エラー{0}個"}, {"main.exception_thrown", "docletクラス{0}では、メソッド{1}は例外{2}をスローしました"}, {"main.fatal.error", "致命的エラー"}, {"main.fatal.exception", "致命的例外"}, {"main.file_not_found", "ファイル\"{0}\"が見つかりません"}, {"main.illegal_locale_name", "ロケール{0}が無効です"}, {"main.illegal_package_name", "パッケージ名\"{0}\"は不正です"}, {"main.incompatible.access.flags", "-public、-private、-packageまたは-protectedのうちの2つ以上を指定しました。"}, {"main.internal_error_exception_thrown", "docletクラス{0}の内部エラーです。メソッド{1}は例外{2}をスローしました"}, {"main.invalid_flag", "{0}は無効なフラグです"}, {"main.locale_first", "オプション-localeは、コマンド行の最初に指定する必要があります。"}, {"main.malformed_locale_name", "ロケール名{0}の書式が正しくありません"}, {"main.more_than_one_doclet_specified_0_and_1", "複数のdoclet({0}と{1})が指定されています。"}, {"main.must_return_boolean", "docletクラス{0}では、メソッド{1}はbooleanを返す必要があります。"}, {"main.must_return_int", "docletクラス{0}では、メソッド{1}はintを返す必要があります。"}, {"main.must_return_languageversion", "docletクラス{0}では、メソッド{1}はLanguageVersionを返す必要があります。"}, {"main.no_source_files_for_package", "パッケージ{0}のソース・ファイルがありません"}, {"main.option.already.seen", "{0}オプションが複数指定されています。"}, {"main.out.of.memory", "java.lang.OutOfMemoryError: メモリーを増やしてください。\nたとえば、JDKのclassicもしくはhotspot VMでは、-J-Xmx32mのように\n-J-Xmxオプションを使用します。"}, {"main.requires_argument", "オプション{0}には引数が必要です。"}, {"main.usage", "使用方法: javadoc [options] [packagenames] [sourcefiles] [@files]\n  -overview <file>          HTMLファイルから概要ドキュメントを読み込む\n  -public                   publicクラスとメンバーのみを示す\n  -protected                protected/publicクラスとメンバーを示す(デフォルト)\n  -package                  package/protected/publicクラスとメンバーを示す\n  -private                  すべてのクラスとメンバーを示す\n  -help                     コマンド行オプションを表示して終了する\n  -doclet <class>           代替docletを介して出力を生成する\n  -docletpath <path>        docletクラス・ファイルを探す場所を指定する\n  -sourcepath <pathlist>    ソース・ファイルのある場所を指定する\n  -classpath <pathlist>     ユーザー・クラス・ファイルのある場所を指定する\n  -cp <pathlist>                   ユーザー・クラス・ファイルのある場所を指定する\r\n  -exclude <pkglist>        除外するパッケージ・リストを指定する\n  -subpackages <subpkglist> 再帰的にロードするサブパッケージを指定する\n  -breakiterator            BreakIteratorで最初の文を計算する\n  -bootclasspath <pathlist> ブートストラップ・クラス・ローダーによりロードされた\n                                   クラス・ファイルの場所をオーバーライドする\n  -source <release>         指定されたリリースとソースの互換性を提供する\n  -extdirs <dirlist>        インストールされた拡張機能の場所をオーバーライドする\n  -verbose                  Javadocの動作についてメッセージを出力する\n  -locale <name>            en_USやen_US_WINなどの使用するロケール\n  -encoding <name>          ソース・ファイルのエンコーディング名\n  -quiet                    状態メッセージを表示しない\n  -J<flag>                  <flag>を実行時システムに直接渡す\n  -X                        非標準オプションの概要を出力し終了する\n"}, {"main.warning", "警告{0}個"}, {"main.warnings", "警告{0}個"}, {"tag.End_delimiter_missing_for_possible_SeeTag", "コメント文字列\"{0}\"で、有効なseeタグに終端デリミタ}がありません"}, {"tag.Improper_Use_Of_Link_Tag", "インライン・タグ\"{0}\"に終了文字''}''がありません"}, {"tag.illegal_char_in_arr_dim", "タグ{0}: 配列の大きさ、メソッド・パラメータ{1}に構文エラーがあります"}, {"tag.illegal_see_tag", "タグ{0}: メソッド・パラメータ{1}に構文エラーがあります"}, {"tag.missing_comma_space", "タグ{0}: メソッド・パラメータ{1}にカンマまたは空白文字がありません"}, {"tag.see.can_not_find_member", "タグ{0}: {2}で{1}が見つかりません"}, {"tag.see.class_not_specified", "タグ{0}: クラスが指定されていません: \"{1}\""}, {"tag.see.illegal_character", "タグ{0}: \"{2}\"に不正な文字\"{1}\"があります"}, {"tag.see.malformed_see_tag", "タグ{0}: 書式が正しくありません: \"{1}\""}, {"tag.see.missing_sharp", "タグ{0}: ''#''がありません: \"{1}\""}, {"tag.see.no_close_bracket_on_url", "タグ{0}: 閉じタグ''>''がありません: \"{1}\""}, {"tag.see.no_close_quote", "タグ{0}: 閉じ引用符がありません: \"{1}\""}, {"tag.serialField.illegal_character", "@serialFieldタグに不正な文字{0}があります: {1}。"}, {"tag.tag_has_no_arguments", "{0}タグに引数がありません。"}};
   }
}
