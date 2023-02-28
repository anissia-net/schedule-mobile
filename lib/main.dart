import 'package:flutter/material.dart';
import 'package:schedule/scheduleView.dart';
import 'package:schedule/theme.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '애니 편성표',
      theme: theme,
      home: ScheduleView(),
    );
  }
}
