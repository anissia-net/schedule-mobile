import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:webview_flutter/webview_flutter.dart';

class ScheduleView extends StatefulWidget {
  @override
  _ScheduleViewState createState() => _ScheduleViewState();
}

class _ScheduleViewState extends State<ScheduleView> {
  late final WebViewController _controller = WebViewController()
    ..setJavaScriptMode(JavaScriptMode.unrestricted)
    ..loadRequest(Uri.parse('https://anissia.net/schedule/2015'))
    ..setNavigationDelegate(NavigationDelegate(
      onNavigationRequest: (navigation) {
        launchUrl(Uri.parse(navigation.url), mode: LaunchMode.externalApplication);
        return NavigationDecision.prevent;
      },
    ));

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        toolbarHeight: 0,
      ),
      body: Builder(builder: (BuildContext context) {
        return WebViewWidget(controller: _controller);
      }),
    );
  }
}