import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:webview_flutter/webview_flutter.dart';

class ScheduleView extends StatefulWidget {
  @override
  ScheduleViewState createState() => ScheduleViewState();
}

class ScheduleViewState extends State<ScheduleView> {
  late final WebViewController controller = WebViewController()
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
    return Padding(
      padding: EdgeInsets.fromLTRB(0, MediaQuery.of(context).padding.top, 0, 0),
      child: WebViewWidget(controller: controller),
    );
  }
}
