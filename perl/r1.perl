$text = "";
while (my $row = <>) {
    $row =~ s/^\s+//g;
    $row =~ s/\s{2,}/ /g;
    $row =~ s/\s+$//g;
    $text = $text . $row . "\n";
}

$text =~ s/^\n+//g;
$text =~ s/\n{2,}/\n\n/g;
$text =~ s/\n+$//g;
print $text;