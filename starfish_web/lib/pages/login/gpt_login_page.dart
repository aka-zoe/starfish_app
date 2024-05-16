import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';

import '../../route/route_utils.dart';
import '../tab_page.dart';

class GptLoginPage extends StatelessWidget {
  const GptLoginPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(
            child: Container(
                padding: EdgeInsets.only(left: 100.w, right: 100.w, top: 80.h, bottom: 80.h),
                child: Row(children: [
                  Expanded(
                      child: Container(
                          color: Colors.blue.shade50,
                          child: Center(
                              child: Column(mainAxisAlignment: MainAxisAlignment.center, children: [
                            Container(width: 250.r, height: 150.r, color: Colors.red),
                            SizedBox(height: 40.h),
                            Container(width: 250.r, height: 150.r, color: Colors.blue),
                            SizedBox(height: 40.h),
                            Container(width: 250.r, height: 150.r, color: Colors.green)
                          ])))),
                  // Right side with login form
                  Expanded(
                      child: Padding(
                          padding: EdgeInsets.all(32.r),
                          child: Column(
                              mainAxisAlignment: MainAxisAlignment.center,
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                  'Thorlabs',
                                  style: TextStyle(
                                    fontSize: 32.sp,
                                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                                SizedBox(height: 8.h),
                                Text(
                                  'Your Source for Optoelectronic Experiment',
                                  style: TextStyle(
                                    fontSize: 16.sp,
                                  ),
                                ),
                                SizedBox(height: 32.h),
                                TextField(
                                  decoration: InputDecoration(
                                    labelText: 'Email Address',
                                    border: OutlineInputBorder(),
                                  ),
                                ),
                                SizedBox(height: 16.h),
                                TextField(
                                  decoration: InputDecoration(
                                    labelText: 'Password',
                                    border: OutlineInputBorder(),
                                  ),
                                  obscureText: true,
                                ),
                                SizedBox(height: 16.h),
                                Row(
                                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                  children: [
                                    Row(
                                      children: [
                                        Checkbox(value: false, onChanged: (value) {}),
                                        Text('Remember me'),
                                      ],
                                    ),
                                    TextButton(
                                      onPressed: () {},
                                      child: Text('Forgot Password?'),
                                    ),
                                  ],
                                ),
                                SizedBox(height: 32.h),
                                Row(
                                  children: [
                                    Expanded(
                                      child: ElevatedButton(
                                        onPressed: () {
                                          RouteUtils.pushAndRemoveUntil(context, const TabPage());
                                        },
                                        child: Text('Login'),
                                      ),
                                    ),
                                    SizedBox(width: 16.w),
                                    Expanded(
                                      child: OutlinedButton(
                                        onPressed: () {},
                                        child: Text('Sign Up'),
                                      ),
                                    ),
                                  ],
                                ),
                                SizedBox(height: 32.h),
                                Row(mainAxisAlignment: MainAxisAlignment.center, children: [
                                  Text('Or login with '),
                                  TextButton(
                                    onPressed: () {},
                                    child: Text('Google'),
                                  ),
                                  Text(' or '),
                                  TextButton(onPressed: () {}, child: Text('Facebook'))
                                ])
                              ])))
                ]))));
  }
}
