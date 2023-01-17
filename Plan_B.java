package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Plan_B extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;
    private DcMotor podnyatie1, podnyatie2;
    private Servo zahvat;

    @Override
    public void runOpMode() throws InterruptedException {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "LF");
        leftBackDrive = hardwareMap.get(DcMotor.class, "LB");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "RF");
        rightBackDrive = hardwareMap.get(DcMotor.class, "RB");
        podnyatie1 = hardwareMap.get(DcMotor.class, "P1");
        podnyatie2 = hardwareMap.get(DcMotor.class, "P2");
        zahvat = hardwareMap.get(Servo.class, "Z");

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            zahvat.setPosition(1);
            rightFrontDrive.setPower(1);
            rightBackDrive.setPower(1);
            leftBackDrive.setPower(1);
            leftFrontDrive.setPower(1); //Вперед
            sleep(500);

            rightFrontDrive.setPower(0);
            rightBackDrive.setPower(0);
            leftBackDrive.setPower(0);
            leftFrontDrive.setPower(0);

            stop();

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
